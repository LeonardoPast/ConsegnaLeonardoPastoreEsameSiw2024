package com.uniroma3.esamesiw2024.security;

import com.uniroma3.esamesiw2024.entity.Credentials;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	DataSource datasource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authz) -> authz
				.requestMatchers(HttpMethod.GET,"/","/index", "/static/**", "/css/**", "/js/**", "/images/**", "/squadra/get-all-squadra-ui/**", "/squadra/get-squadra/**", "/register", "/giocatore/get-all-giocatore-ui/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
				.requestMatchers(HttpMethod.GET, "/squadra/form-squadra-update-admin/{id}/").hasRole(Credentials.ADMIN_ROLE)
				.requestMatchers(HttpMethod.POST, "/squadra/update-squadra-ui/{id}/").hasRole(Credentials.ADMIN_ROLE)
				.requestMatchers(HttpMethod.GET, "/squadra/formPlayer/{idSquadra}/").hasRole(Credentials.PRESIDENTE_ROLE)
				.requestMatchers(HttpMethod.POST, "/squadra/add-player-ui/{idSquadra}/").hasRole(Credentials.PRESIDENTE_ROLE)
						.anyRequest().authenticated());
				/*.requestMatchers(HttpMethod.POST,"/basic/**", "/basic/login", "/basic/register").permitAll()
				//.requestMatchers(HttpMethod.GET, "/user/**", "/**").hasAnyAuthority(DEFAULT_ROLE)
				//.requestMatchers(HttpMethod.POST, "/user/**", "/user/formNewPersonaggio").hasAnyAuthority(DEFAULT_ROLE)
				.anyRequest().authenticated());*/
		http.formLogin((form) ->form
				.loginPage("/login")
				.defaultSuccessUrl("/success")
				.permitAll());
		http.logout((logout) -> logout
				.logoutSuccessUrl("/")
				.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.deleteCookies("JSESSIONID")
				.permitAll());
		HttpSessionRequestCache req = new HttpSessionRequestCache();
		req.setMatchingRequestParameterName(null);
		http.requestCache((cache) -> cache
				.requestCache(req));
		http.exceptionHandling((exceptionHandling) -> exceptionHandling
				.accessDeniedPage("/login"));
		http.csrf(AbstractHttpConfigurer::disable);


		return http.build();


    }
    
  //---------- SINGOLO UTENTE SCOLPITO ----------------------------
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withUsername("presidente")
				.username("presidente")
				.password(passwordEncoder().encode("password"))
			    .roles("PRESIDENTE")
			 	.build();
		return new InMemoryUserDetailsManager(user);
	}
	//---------- FINE SINGOLO UTENTE SCOLPITO ----------------------------

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	@Primary
	public AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(this.datasource)
				//query per recuperare username e ruolo
				.authoritiesByUsernameQuery("SELECT username, role FROM credentials WHERE username=?")
				//query per username e password. Il flag boolean flag specifica se l'utente user è abilitato o no (va sempre a true)
				.usersByUsernameQuery("SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
		return  auth;
	}

}
