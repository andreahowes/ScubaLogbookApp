package com.andreahowes.dive_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DiveDbApplication {//extends SpringBootServletInitializer {

  //@Override
  //protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
  //    return application.sources(DiveDbApplication.class);
  //}
    public static void main(String[] args) {
        SpringApplication.run(DiveDbApplication.class, args);
    }
}
