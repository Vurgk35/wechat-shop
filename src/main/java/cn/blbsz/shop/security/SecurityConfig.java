package cn.blbsz.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
          .authorizeRequests()
              .antMatchers("/", "/home").permitAll()//不需要登录的地址，其它都需要登录
              .anyRequest().authenticated()
              .and()
          .formLogin()
              .loginPage("/user/login")//登录的地址
//              .defaultSuccessUrl("/helloadmin")//登录成功后跳转的地址
//              .loginProcessingUrl("/aaa")
              .permitAll()
              .and()
          .logout()
              .permitAll();
	}
}
