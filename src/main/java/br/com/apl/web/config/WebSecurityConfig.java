package br.com.apl.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.apl.web.security.GpUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private GpUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.																	//Configuracao de permissao das URLs
			authorizeRequests()													//Configirar como as requisições serão feitas
				.antMatchers("/projetos").hasAnyRole("PG_PROJETOS")				//Permissao especifica para a pagina de projetos
				.antMatchers("/relatorio-equipe").hasAnyRole("PG_REL_EQUIPE")	//Permissao especifica para a pagina de relatorios equipe
				.antMatchers("/relatorio-custos").hasAnyRole("PG_REL_CUSTOS")	//Permissao especifica para a pagina de relatorios custos
				.anyRequest()			                                        //Pra qualquer requisição 
				.authenticated()		                                        //Usuário deve estar autenticado
			.and()						                                        //Adicionar mais uma configuracao
			.formLogin()				                                        //Login é realizado por um formulario HTML | caso não tenha uma pag propria o framework abre uma padrão
				.loginPage("/entrar")	                                        //Página própria de login
				.permitAll()													//Permite acesso a todos
			.and()
			.logout()
				.logoutSuccessUrl("/entrar?logout")
				.permitAll()
			.and()
				.rememberMe()
				.userDetailsService(userDetailsService);
	}                                                                           
}
