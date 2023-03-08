package com.moh.crmspring.config;

import com.moh.crmspring.converters.ActivityRequestToActivity;
import com.moh.crmspring.converters.ActivityToActivityResponse;
import com.moh.crmspring.converters.ContactRequestToContact;
import com.moh.crmspring.converters.ContactToContactResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {
    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();

        Set<Converter> converters = new HashSet<>();
        converters.add(contactRequestToContact());
        converters.add(contactToContactResponse());
        converters.add(activityRequestToActivityConverter());
        converters.add(activityToActivityResponseConverter());

        conversionServiceFactoryBean.setConverters(converters);
        conversionServiceFactoryBean.afterPropertiesSet();

        return conversionServiceFactoryBean;
    }

    @Bean
    public ContactRequestToContact contactRequestToContact() {
        return new ContactRequestToContact();
    }

    @Bean
    public ContactToContactResponse contactToContactResponse() {
        return new ContactToContactResponse();
    }

    @Bean
    public ActivityRequestToActivity activityRequestToActivityConverter() {
        return new ActivityRequestToActivity();
    }

    @Bean
    public ActivityToActivityResponse activityToActivityResponseConverter() {
        return new ActivityToActivityResponse();
    }
}
