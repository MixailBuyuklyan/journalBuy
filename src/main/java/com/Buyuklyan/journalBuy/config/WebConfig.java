package com.Buyuklyan.journalBuy.config;

import com.Buyuklyan.journalBuy.domain.User;
import com.Buyuklyan.journalBuy.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final UserService userService;

    @Autowired
    public WebConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, User>() {
            @Override
            public User convert(String source) {
                // Удаление пробелов и невидимых символов
                String cleanedId = source.replaceAll("[\\s\\u00A0]+", "");
                Long id = Long.parseLong(cleanedId);
                return userService.findById(id);
            }
        });
    }
}