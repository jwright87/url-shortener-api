package jwright.bluebik.shorten;

import com.google.common.hash.Hashing;
import jwright.bluebik.repository.HashMapURLDAO;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.Random;
@Service
public class BasicURLShortenService implements URLShortenService {

    private HashMapURLDAO urlDAO;
    private Random random;
    private final char[] ALL_VALID_CHARS = createAllValidCharsArray();

    char[] createAllValidCharsArray() {
        final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] capitalAlphabet = new String(alphabet).toUpperCase().toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        char[] allValidChars = ArrayUtils.addAll(capitalAlphabet, alphabet);
        allValidChars = ArrayUtils.addAll(allValidChars, numbers);
        return allValidChars;
    }

    public BasicURLShortenService(HashMapURLDAO urlDAO) {
        this.random = new Random();
        this.urlDAO=urlDAO;
    }

    @Override
    public String shortenURL(String url) {
        setRandomSeedAsSHA256(url);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(ALL_VALID_CHARS[random.nextInt(ALL_VALID_CHARS.length)]);
        }
        String shortUrl = sb.toString();
        urlDAO.save(shortUrl,url);
        return shortUrl;
    }

    /**
     * Sets the random number generator's seed to be the integer value of the url's sha256
     * @param url
     */
    void setRandomSeedAsSHA256(String url) {
        int sha256hex = Hashing.sha256()
                .hashString(url, StandardCharsets.UTF_8).asInt();
        random.setSeed(sha256hex);
    }
}
