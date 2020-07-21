package com.cloud.oauth2server.config;

import com.cloud.oauth2server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    /**
     *
     * when use password mode need config
    * */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager)
                    .userDetailsService(userService);
        }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")// config client_id
                .secret(passwordEncoder.encode("admin123456"))//config client_secret
                .accessTokenValiditySeconds(3600)//config access token validate time
                .refreshTokenValiditySeconds(864000)//config refresh token's validate
                .redirectUris("http://www.google.com")//config redirect_uri，used for redirecting after succeeding authorization
                .scopes("all")// config the scope for applying the auth
                .authorizedGrantTypes("authorization_code","password");//config grant_type，auth type
    }
}
