package org.top.pokemon.finder.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/pokemons/weight").permitAll()
                .antMatchers("/pokemons/height").permitAll()
                .antMatchers("/pokemons/baseExperience").permitAll()
                .antMatchers("/actuator/*").permitAll()
                .anyRequest().authenticated();
    }
}
