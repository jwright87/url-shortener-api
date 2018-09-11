package jwright.bluebik.repository;

public interface URLDAO {

    void save(String shortURL, String url);

    String get(String shortUrl);
}
