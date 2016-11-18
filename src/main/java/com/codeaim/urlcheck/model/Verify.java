package com.codeaim.urlcheck.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
public class Verify
{
    @NotNull
    private String emailVerificationToken;
}
