package jwright.bluebik.util;

import jwright.bluebik.exception.InvalidURLException;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    private UrlValidator urlValidator = new UrlValidator();

    public void validateURL(String url) {
        if (!urlValidator.isValid(url)) {
            logger.info("URL provided invalid: {}", url);
            throw new InvalidURLException();
        }
    }
}
