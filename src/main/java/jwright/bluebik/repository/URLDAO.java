package jwright.bluebik.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class URLDAO {

    private Map<String, String> map = new HashMap<>();

    public void save(String shortURL, String url) {
        map.put(shortURL, url);
    }

    public String get(String shortUrl) {
        return map.get(shortUrl);
    }
}
