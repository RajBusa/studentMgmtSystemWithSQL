package in.ac.charusat.studentmgmtsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
//3.
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//    2.

    @Autowired
    DataSource dataSource;

//    3.
//    @Autowired
//    UserServices userServices;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        1.
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password("user123")
//                .roles("USER");


//              2.
             auth.jdbcAuthentication().dataSource(dataSource);
//                     .withDefaultSchema()
//                     .withUser(
//                             User.withUsername("admin")
//                             .password("admin")
//                             .roles("ADMIN")
//                     )
//                     .withUser(
//                             User.withUsername("user")
//                                     .password("user")
//                                     .roles("USER")
//                     );
//        3.
//        auth.userDetailsService(userServices);

    }
//    2.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
//        http.authorizeRequests().antMatchers("/signup").permitAll();


    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
