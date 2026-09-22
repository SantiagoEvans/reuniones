package es.desrroma.school.springboot.reuniones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // 1. Rutas específicas de la API REST que requieren un rol específico
                .requestMatchers("/api/rest/**").hasRole("API_USER")
                
                // 2. Rutas del Actuator y la raíz del sitio
                .requestMatchers("/", "/actuator/**").permitAll() 
                
                // 3. Cualquier otra ruta de la aplicación requiere autenticación
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            );

        return http.build();

    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails usuario1 = User.builder().username("granjefe").password(paswordEncoder().encode("ssshhh")).roles("USER","","API_USER").build();
        UserDetails usuario2 = User.builder().username("currito").password(paswordEncoder().encode("pasapasa")).roles("USER").build();
        return new InMemoryUserDetailsManager(usuario1, usuario2);
    }

    @Bean
    public PasswordEncoder paswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
