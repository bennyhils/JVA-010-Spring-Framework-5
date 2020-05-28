package com.luxoft.jva010.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class AppConfig implements WebMvcConfigurer
{
    public NamesService namesService()
    {
        return new InMemoryNamesService();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer)
    {
        configurer
                .setUseSuffixPatternMatch(true)
                .setUseTrailingSlashMatch(false)
                .setUseRegisteredSuffixPatternMatch(true)
                .addPathPrefix("", HandlerTypePredicate.forAnnotation(RestController.class));
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
}
