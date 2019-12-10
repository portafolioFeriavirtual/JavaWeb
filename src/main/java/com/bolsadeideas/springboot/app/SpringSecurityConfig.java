package com.bolsadeideas.springboot.app;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bolsadeideas.springboot.app.auth.handler.LoginSuccessHandler;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter	{
	
//	@Autowired DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/", "/css/**", "/js/**","/images/**","/listar").permitAll()
    	.antMatchers("/ver/**").hasAnyRole("USER")
    	.antMatchers("/uploads/**").hasAnyRole("USER")
    	.antMatchers("/form/**").hasAnyRole("ADMIN")
    	.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
    	.antMatchers("/factura/**").hasAnyRole("ADMIN")
    	.antMatchers("/listaproductor/**").hasAnyRole("ADMIN")
    	.antMatchers("/factura/**").hasAnyRole("ADMIN")
    	.antMatchers("/listaproductor/**").hasAnyRole("PRODUCTOR")
    	.antMatchers("/listaproductor/**").hasAnyRole("ADMIN")
				/* .antMatchers("/eliminar/**").hasAnyRole("PRO") */
    	.anyRequest().authenticated()
    	.and()
    		.formLogin()
    		.successHandler(successHandler)
    		.loginPage("/login")
    		.permitAll()
    	  .and()
    	.logout().permitAll()
    	.and()
    	.exceptionHandling().accessDeniedPage("/error_403");
    	
//     	.exceptionHandling().accessDeniedPage("/error_404");
	}


	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
			builder.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
		
	}
	
	
//	@Autowired
//	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
//		
//    	PasswordEncoder encoder = passwordEncoder;
//		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
//		builder.inMemoryAuthentication()
//		.withUser(users.username("admin").password("12345").roles( "ADMIN", "USER"))
//		.withUser(users.username("jose").password("12345").roles( "USER"));
//		/*.withUser(users.username("india").password("12345").roles( "PRO"));*/
//		
//	}
//	
	
	
	
	
}
