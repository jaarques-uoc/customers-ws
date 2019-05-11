package com.jaarquesuoc.shop.customers;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class TestConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/customers/*")
            .permitAll()
            .antMatchers("/actuator/*")
            .permitAll();
        super.configure(http);
    }
}
