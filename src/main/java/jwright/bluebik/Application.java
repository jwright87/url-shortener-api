package jwright.bluebik;

import jwright.bluebik.service.shorten.BasicURLShortenService;
import jwright.bluebik.service.shorten.URLShortenService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public URLShortenService urlShortenService() {
//        return new BasicURLShortenService(new Random());
//    }

}
