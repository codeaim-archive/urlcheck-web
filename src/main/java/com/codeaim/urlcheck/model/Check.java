package com.codeaim.urlcheck.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Check
{
    private long id;
    private String name;
    private String url;
    private Status status;
    private Long latestResultId;
    private boolean confirming;
}