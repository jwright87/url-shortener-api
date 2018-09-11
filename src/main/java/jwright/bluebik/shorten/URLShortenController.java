package jwright.bluebik.shorten;

import jwright.bluebik.model.URLResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLShortenController {


    private static final Logger logger = LoggerFactory.getLogger(URLShortenController.class);
    private URLShortenService shortenService;

    public URLShortenController(URLShortenService shortenService) {
        this.shortenService = shortenService;
    }

    @RequestMapping(value = "/api/shorten", method = RequestMethod.GET)
    public URLResponse shorten(@RequestParam String url) {
        logger.debug("Shortening url: {}", url);
        URLResponse resp = new URLResponse();
        resp.setShortenedURL(shortenService.shortenURL(url));
        return resp;
    }
}
