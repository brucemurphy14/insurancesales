package com.insuranceproject.insurancesales.SecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

/**
 * Configures Spring web security features.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

/**
     * Connects to datasource and retrieves usernames/password from users table.
     * @param auth
     * @throws Exception
     */
    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }


     /**
     * authenticates login information inputted from the built in form. Triggers when the /login URL is navigated to and requires a valid log in.
     * @param http
     * @throws Exception
     */

    @Override
    protected  void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").hasRole("CLIENT")
              //  .antMatchers("/").permitAll()
                .and().formLogin()
                .defaultSuccessUrl("/index.html", true);
                http.csrf().disable();
    }

     /**
     * The most simple password encryption. I.E none at all.
     * @return
     */

    //TODO implement some sort of password hashing.
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
