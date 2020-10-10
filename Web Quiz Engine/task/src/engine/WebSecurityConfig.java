package engine;


import engine.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    /*   private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationEntryPoint authEntryPoint;

 @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, AuthenticationEntryPoint authEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.authEntryPoint = authEntryPoint;
    }*/



   @Override
   protected void configure(HttpSecurity http) throws Exception {
  /*     http.authorizeRequests()
//                .antMatchers("/**").authenticated()
               .antMatchers(  "/", "/api/register").permitAll()
               //.antMatchers("/api/quizzes/**").authenticated()


//                .antMatchers("/**").permitAll()
               .anyRequest().authenticated()
               .and()
               .httpBasic()
               .and()
               .csrf().disable()
               .headers()
               .frameOptions().disable()
               .and() // todo: fix logout
               .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));*/
       http.cors().and().csrf().disable()
               .httpBasic()

               .and()
               .authorizeRequests()
               .antMatchers("/", "/api/xyz","/login").permitAll()

               .anyRequest().authenticated();

   }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
