package com.codeaim.urlcheck.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class Check
{
    private Long id;
    private String name;
    @NotNull
    @NotEmpty
    private String url;
    private Status status;
    private Long latestResultId;
    @NotNull
    private Integer interval;
    private String path;
    private String protocol;
    private boolean confirming;
    private boolean disable;
    private boolean checkDisabled;
    private Instant disabled;
    private Set<Header> headers;
    private List<Header> headerList;
}