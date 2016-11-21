package com.codeaim.urlcheck.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
public class Register
{
    @NotNull
    private String username;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;

    @AssertTrue(message="password doesn't match the confirmation password")
    private boolean isValid() {
        return this.password.equals(this.confirmPassword);
    }
}
