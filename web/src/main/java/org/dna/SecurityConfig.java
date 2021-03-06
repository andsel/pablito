package org.dna;

import org.dna.model.BidderRepository;
import org.dna.model.TaskerRepository;
import org.dna.web.infrastructure.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by andrea on 28/07/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    TaskerRepository taskerRepository;

    @Autowired
    BidderRepository bidderRepository;

    @Autowired
    UserDetailsService customUserService;

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        //This auth success handler is a customization to use referrer only
        //for navbar login, to stay on the same page.
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler() {
            protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
                boolean useReferToIncomingPage = !request.getRequestURI().endsWith("/login") ||
                        request.getParameterValues("_fromLoginPage") == null;
                setUseReferer(useReferToIncomingPage);
                return super.determineTargetUrl(request, response);
            }
        };
        return handler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .successHandler(successHandler())
            .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
            .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/tasker/hire").hasRole("REQUESTER")//.authenticated()
                .antMatchers("/tasker/requests").hasRole("TASKER")
                .anyRequest().permitAll();

        //WARN only in Dev mode
        //TODO use environment to selectively execute this
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //just for dev test
//        auth.inMemoryAuthentication()
//                .withUser("requester").password("pwd").roles("ROLE_REQUESTER").and()
//                .withUser("tasker").password("pwd").roles("ROLE_TASKER");
        auth.userDetailsService(this.customUserService);
    }
}
