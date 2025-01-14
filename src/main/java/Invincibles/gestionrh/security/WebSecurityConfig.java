    package Invincibles.gestionrh.security;
        
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
    //import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
    import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    //import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    //import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
    
    
    import Invincibles.gestionrh.service.UserDetailsServiceImpl;
    
    @Configuration
    @EnableMethodSecurity
    public class WebSecurityConfig {
      @Autowired
      UserDetailsServiceImpl userDetailsService;
    
      @Autowired
      private AuthEntryPointJwt unauthorizedHandler;
    
      @Bean
      public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
      }
    
      
      @Bean
      public DaoAuthenticationProvider authenticationProvider() {
          DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
           
          authProvider.setUserDetailsService(userDetailsService);
          authProvider.setPasswordEncoder(passwordEncoder());
       
          return authProvider;
      }
    
      
      @Bean
      public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
      }
    
      @Bean
      public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
      }
    
      @Bean
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          http.csrf(csrf -> csrf.disable())
              .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
              .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authorizeHttpRequests(auth -> 
                  auth.requestMatchers("/api/auth/**").permitAll()
                      .requestMatchers("/api/test/**").permitAll()
                      .requestMatchers("/absences/**").permitAll()
                      .requestMatchers("/conges/**").permitAll()
                      .requestMatchers("/departements/**").permitAll()
                      .requestMatchers("/employes/**").permitAll()
                      .requestMatchers("/gestionnairesrh/**").permitAll()
                      .requestMatchers("/payments/**").permitAll()
                      .requestMatchers("/posts/**").permitAll()
                      .requestMatchers("/primes/**").permitAll()
                      .requestMatchers("/reclamations/**").permitAll()
                      .requestMatchers("/salaires/**").permitAll()
                      .requestMatchers("/vacances/**").permitAll()
                      .requestMatchers("/parametres/**").permitAll()
                      .requestMatchers("/salairesconfig/**").permitAll()
                      .requestMatchers("/repos/**").permitAll()
                      .requestMatchers("/demissions/**").permitAll()
                      .anyRequest().authenticated()
              );
          
          // Add the AuthTokenFilter before the UsernamePasswordAuthenticationFilter
          http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
          http.authenticationProvider(authenticationProvider());
    
          return http.build();
      }
      
      
    }