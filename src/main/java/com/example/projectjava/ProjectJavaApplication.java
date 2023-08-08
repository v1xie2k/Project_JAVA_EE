package com.example.projectjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class ProjectJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectJavaApplication.class, args);
    }

    Locale localeIndonesia = new Locale("id", "ID");

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(localeIndonesia);
        return sessionLocaleResolver;
    }

}
