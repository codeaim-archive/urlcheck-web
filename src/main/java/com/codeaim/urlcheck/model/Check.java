package com.codeaim.urlcheck.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    @NotNull
    private Integer interval;
    @NotNull
    @NotEmpty
    private String path;
    @NotNull
    private String protocol;
    private boolean confirming;
    private Set<Header> headers;
    private List<Header> headerList;
}