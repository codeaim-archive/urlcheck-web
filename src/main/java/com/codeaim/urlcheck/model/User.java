package com.codeaim.urlcheck.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User
{
    private long id;
    private String username;
    private String password;
    private boolean emailVerified;
    private List<Role> roles;
}
