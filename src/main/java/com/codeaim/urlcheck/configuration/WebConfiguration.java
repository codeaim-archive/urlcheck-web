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
    private String getChecksByUsernameEndpoint = "http://api.urlcheck.io/check/{username}";
    private String createCheckEndpoint = "http://api.urlcheck.io/check/{username}";
    private String deleteCheckEndpoint = "http://api.urlcheck.io/check/{username}/{id}";
    private String updateCheckEndpoint = "http://api.urlcheck.io/check/{username}/{id}";
    private String getUserByUsernameEndpoint = "http://api.urlcheck.io/user/{username}";
}
