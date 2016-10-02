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
    private String getChecksEndpoint = "http://localhost:6601/check";
}
