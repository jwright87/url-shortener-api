package jwright.bluebik.service.shorten;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BasicURLShortenServiceTest {

    @Test
    public void createAllValidCharsArray() {
        BasicURLShortenService urlShortenService = new BasicURLShortenService(new Random(10));
        char[] allValidChars = urlShortenService.createAllValidCharsArray();
        System.out.println(allValidChars);//TODO remove
        assertEquals(26+26+10,allValidChars.length);
    }

    @Test
    public void shortenURL() {
        BasicURLShortenService urlShortenService = new BasicURLShortenService(new Random());
        String shortened = urlShortenService.shortenURL("www.google.com");
        System.out.println(shortened);
         shortened = urlShortenService.shortenURL("https://www.google.com");
        System.out.println(shortened);
    }
}