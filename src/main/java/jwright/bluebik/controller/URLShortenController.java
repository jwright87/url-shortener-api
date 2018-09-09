package jwright.bluebik.controller;

import jwright.bluebik.model.URLResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLShortenController {

    @RequestMapping(value = "/shorten", method = RequestMethod.POST)
    public URLResponse shorten(@RequestParam String url) {
        URLResponse resp = new URLResponse();
        resp.setShortenedURL("test.url/" + url);
        return resp;
    }
}
