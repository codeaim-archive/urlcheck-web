package com.codeaim.urlcheck.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "urlcheck.web")
public class WebConfiguration
{
    private String getChecksByUsernameEndpoint = "http://localhost:6601/check/{username}";
    private String createCheckEndpoint = "http://localhost:6601/check/{username}";
    private String deleteCheckEndpoint = "http://localhost:6601/check/{username}/{id}";
    private String updateCheckEndpoint = "http://localhost:6601/check/{username}/{id}";
    private String getUserByUsernameEndpoint = "http://localhost:6601/user/{username}";
}
