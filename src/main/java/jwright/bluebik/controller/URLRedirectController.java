package jwright.bluebik.controller;

import jwright.bluebik.repository.URLDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URLRedirectController {

    private static final Logger logger = LoggerFactory.getLogger(URLRedirectController.class);
    private URLDAO urlDAO;

    public URLRedirectController(URLDAO urlDAO) {
        this.urlDAO = urlDAO;
    }

    @RequestMapping("/{shortURL}")
    public ResponseEntity<?> redirectURL(@PathVariable(value = "shortURL") String shortURL) {
        logger.debug("Redirecting Short URL: {}", shortURL);
        String url = urlDAO.get(shortURL);
        logger.debug("Redirecting to full url: {}", url);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header(HttpHeaders.LOCATION, "http://" + url).build();
    }

}
