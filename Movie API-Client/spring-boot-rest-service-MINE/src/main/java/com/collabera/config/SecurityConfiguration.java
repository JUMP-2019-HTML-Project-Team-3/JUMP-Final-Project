package com.collabera.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Security configuration of the application is used for the following: 1. Make
 * sure that the restricted or secure APIs are accessed only by authenticated
 * users. 2. Describes the kind of authentication which the application supports
 * 3. Declares URLs and pages which can be publicly accessed in a insecure
 * manner 4. Also defines where the username and passwords are stored for valid
 * users.
 * 
 *
 */
@Configuration
// the annotation tells spring container that this is a configuration setting. This class defines some kind of configuration
@EnableWebSecurity
// the annotation confirms that the application has security at the web layer. Which means that any request to APIs can be made secure and this allows Spring to setup the security infrastructure for web applications/API
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// use this encoder to not allow plain text passwords
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // this is the password encoder we use to encode plain text into a encoded value. See on line number 68
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configuration to allow basic authentication and disable CSRF
		http.csrf().disable()
				// disable CSRF support. CSRF is a vulnerability in web applications. Generally
				// we dont need CSRF
				// (https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)) in APIs
				.authorizeRequests()
				.antMatchers("/js/**", "/css/**", "/img/**", "/webjars/**", "/api/**").permitAll() // allow all webjars (bootstrap and jquery), css, images and javascript files without security
				.antMatchers("/**").hasRole("USER").anyRequest().authenticated()// authorize requests only if they are successfully authenticated
				.and().formLogin() // allow form login
				.successHandler(authenticationSuccessHandler()) // if login is successful, call the authenticationSuccessHandler method
				.loginPage("/login").permitAll() // show the login page located at /login URL
				.and().httpBasic(); // also allow http basic authentication
				
				// Use basic authentication (username/password based) for all authentication purpose
	}
	
	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/**
	 * handler to redirect to bills page when the authentication is successful
	 * 
	 * @return
	 */
	private AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new AuthenticationSuccessHandler() {
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				redirectStrategy.sendRedirect(request, response, "/movie-list"); // redirect to movie list page
			}
		};
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// configuration to allow these urls accessed regardless of spring security
		// configurations
		web
			.ignoring() 
				// ignore security for all the below URL patterns and HTTP methods
				.antMatchers(HttpMethod.OPTIONS, "/**") // Ignore security for HTTP method (OPTIONS)
				.antMatchers("/static/**")
				.antMatchers("/templates/**")
				.antMatchers("/app/**/*.{js,html}")
				.antMatchers("/swagger-ui/index.html"); // ignore security for the swagger UI
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// in memory authentication database with credentials name admin/password
		auth.inMemoryAuthentication() // the username and password of all valid users is stored in memory.
				.withUser("admin") // the first username entry is admin and the password for this user is 'password' 
				.password("$2a$10$o4YaL1C5Q.Je32FfccrFD.nQotX1p/hDK1TUIrtDW9pLiP0o19AIK") // the password for the user is stored in encrypted form
				.roles("USER"); // the role for the user is 'USER'
	}
}

