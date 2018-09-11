package jwright.bluebik.redirect;

import jwright.bluebik.repository.HashMapURLDAO;
import org.springframework.stereotype.Service;

@Service
public class URLRedirectService {

    private HashMapURLDAO urlDAO;

    public URLRedirectService(HashMapURLDAO urlDAO) {
        this.urlDAO = urlDAO;
    }

    public String getRedirectURL(String shortURL) {
        String fullUrl = urlDAO.get(shortURL);
        return fullUrl;
    }
}
