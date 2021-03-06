package fi.haaga.spring.projekti.Elokuvat.Elokuvat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/css/**").permitAll()
	 	.and()
		.authorizeRequests()
		.antMatchers("save", "add", "elokuvalist", "delete/{id}").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/elokuvalist")
				.permitAll()
				.and()
			.logout()
				.permitAll();
			
	
}

@Autowired

public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
	auth
	
		.inMemoryAuthentication()
		   .withUser("user").password("user").roles("USER").and()
		   .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
}


}

