package jwright.bluebik.redirect;

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
    private URLRedirectService redirectService;

    public URLRedirectController(URLRedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @RequestMapping("/{shortURL}")
    public ResponseEntity<?> redirectURL(@PathVariable(value = "shortURL") String shortURL) {
        logger.debug("Redirecting Short URL: {}", shortURL);
        String fullUrl = redirectService.getRedirectURL(shortURL);
        logger.debug("Redirecting to full url: {}", fullUrl);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header(HttpHeaders.LOCATION, fullUrl).build();
    }

}
