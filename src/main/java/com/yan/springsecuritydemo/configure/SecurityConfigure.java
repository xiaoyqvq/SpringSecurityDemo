package com.yan.springsecuritydemo.configure;

import com.yan.springsecuritydemo.service.impl.LoginUserdetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
        @Bean
        PasswordEncoder passwordEncoder(){
            return NoOpPasswordEncoder.getInstance();
        }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new LoginUserdetailService();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers("/js/**","/css/**","/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.html")
                .permitAll().and().csrf().disable();

    }
}
