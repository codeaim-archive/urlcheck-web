<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <title>urlcheck.io</title>
    <meta name="description" content="A simple url monitor">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/css/font-awesome.css">
    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="Site">
<header class="Site-header">
    <div class="Header">
        <div class="Header-title">
            <a href="/"><i class="icon-urlcheck"></i><span> urlcheck.</span><span class="Header-color">io</span></a>
        </div>
        <div class="Header-action">
            <p>signed in as <a href="#">${username}</a> <i class="fa fa-user"></i> | <i class="fa fa-sign-out"></i>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value=" sign out"/>
            </form>
            </p>

        </div>

    </div>
</header>
<#if checks?size gt 0>
<section class="Status <#if downCount gt 0>Status-down</#if>">
    <div class="Status-content">
        <#if downCount == 0>
            Up and running!
        <#else>
        ${downCount} down
        </#if>
    </div>
</section>
</#if>
<main class="Site-content">
    <div class="Container">
    <#if checks?size == 0>
        <p class="Check-create-title">Create your first check</p>
    </#if>
        <section id="create" class="Check-create">
            <form name="create-check" action="/check" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="Check-create-url-name-interval-actions-group">
                    <div class="Check-create-url">
                        <div class="Check-create-field">
                            <i class="fa fa-plus"></i>
                            <select name="protocol" title="Protocol">
                                <option value="http">http</option>
                                <option value="https">https</option>
                            </select>
                            <span>://</span>
                            <input type="text" name="path" title="Url" placeholder="www.website.com"/>
                        </div>
                    </div>
                    <div class="Check-create-name-interval-actions-group">
                        <div class="Check-create-name">
                            <div class="Check-create-field">
                                <i class="fa fa-bookmark-o"></i>
                                <input type="text" name="name" title="Alias" placeholder="alias (optional)"/>
                            </div>
                        </div>
                        <div class="Check-create-interval-actions-group">
                            <div class="Check-create-interval">
                                <div class="Check-create-field">
                                    <i class="fa fa-arrows-h"></i>
                                    <select name="interval" title="Interval">
                                        <option value="1">every minute</option>
                                        <option value="2">every 2 minutes</option>
                                        <option value="5">every 5 minutes</option>
                                        <option value="10">every 10 minutes</option>
                                        <option value="15">every 15 minutes</option>
                                        <option value="30">every 30 minutes</option>
                                        <option value="60">every hour</option>
                                    </select>
                                </div>
                            </div>
                            <div class="Check-create-actions">
                                <label for="settings-show">
                                    <i class="fa fa-sliders"></i>
                                </label>
                                <button type="submit">
                                    <i class="fa fa-save"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="checkbox" id="settings-show" role="button">
                <input type="checkbox" name="headerList[1].active" id="show-header-2" role="button">
                <input type="checkbox" name="headerList[2].active" id="show-header-3" role="button">
                <input type="checkbox" name="headerList[3].active" id="show-header-4" role="button">
                <input type="checkbox" name="headerList[4].active" id="show-header-5" role="button">
                <input type="checkbox" name="headerList[5].active" id="show-header-6" role="button">
                <div id="settings">
                    <div class="Check-create-header">
                        <div class="Check-create-header-name">
                            <i class="icon-header"></i>
                            <input type="hidden" name="headerList[0].active" value="true" />
                            <input type="text" name="headerList[0].name" title="Header name" placeholder="header name" />
                        </div>
                        <div class="Check-create-header-value">
                            <input type="text" name="headerList[0].value" title="Header value"
                                   placeholder="header value" />
                            <label id="header-2-on" for="show-header-2">
                                <i class="fa fa-plus-square-o"></i>
                            </label>
                            <label id="header-2-off" for="show-header-2">
                                <i class="fa fa-minus-square-o"></i>
                            </label>
                        </div>
                    </div>

                    <div id="header-2" class="Check-create-header">
                        <div class="Check-create-header-name">
                            <i class="icon-header"></i>
                            <input type="hidden" name="headerList[1].active" value="true" />
                            <input type="text" name="headerList[1].name" title="Header name" placeholder="header name" />
                        </div>
                        <div class="Check-create-header-value">
                            <input type="text" name="headerList[1].value" title="Header value"
                                   placeholder="header value" />
                            <label id="header-3-on" for="show-header-3">
                                <i class="fa fa-plus-square-o"></i>
                            </label>
                            <label id="header-3-off" for="show-header-3">
                                <i class="fa fa-minus-square-o"></i>
                            </label>
                        </div>
                    </div>

                    <div id="header-3" class="Check-create-header">
                        <div class="Check-create-header-name">
                            <i class="icon-header"></i>
                            <input type="hidden" name="headerList[2].active" value="true" />
                            <input type="text" name="headerList[2].name" title="Header name" placeholder="header name" />
                        </div>
                        <div class="Check-create-header-value">
                            <input type="text" name="headerList[2].value" title="Header value"
                                   placeholder="header value" />
                            <label id="header-4-on" for="show-header-4">
                                <i class="fa fa-plus-square-o"></i>
                            </label>
                            <label id="header-4-off" for="show-header-4">
                                <i class="fa fa-minus-square-o"></i>
                            </label>
                        </div>
                    </div>

                    <div id="header-4" class="Check-create-header">
                        <div class="Check-create-header-name">
                            <i class="icon-header"></i>
                            <input type="hidden" name="headerList[3].active" value="true" />
                            <input type="text" name="headerList[3].name" title="Header name" placeholder="header name" />
                        </div>
                        <div class="Check-create-header-value">
                            <input type="text" name="headerList[3].value" title="Header value"
                                   placeholder="header value" />
                            <label id="header-5-on" for="show-header-5">
                                <i class="fa fa-plus-square-o"></i>
                            </label>
                            <label id="header-5-off" for="show-header-5">
                                <i class="fa fa-minus-square-o"></i>
                            </label>
                        </div>
                    </div>

                    <div id="header-5" class="Check-create-header">
                        <div class="Check-create-header-name">
                            <i class="icon-header"></i>
                            <input type="hidden" name="headerList[4].active" value="true" />
                            <input type="text" name="headerList[4].name" title="Header name" placeholder="header name" />
                        </div>
                        <div class="Check-create-header-value">
                            <input type="text" name="headerList[4].value" title="Header value"
                                   placeholder="header value" />
                            <label id="header-6-on" for="show-header-6">
                                <i class="fa fa-plus-square-o"></i>
                            </label>
                            <label id="header-6-off" for="show-header-6">
                                <i class="fa fa-minus-square-o"></i>
                            </label>
                        </div>
                    </div>

                    <div id="header-6" class="Check-create-header">
                        <div class="Check-create-header-name">
                            <i class="icon-header"></i>
                            <input type="hidden" name="headerList[5].active" value="true" />
                            <input type="text" name="headerList[5].name" title="Header name" placeholder="header name" />
                        </div>
                        <div class="Check-create-header-value">
                            <input type="text" name="headerList[5].value" title="Header value"
                                   placeholder="header value" />
                        </div>
                    </div>

                    <div class="Check-create-internal">
                        <i class="fa fa-cloud-download"></i>
                        <span>internal</span>
                        <input name="internal" type="checkbox" id="internal" role="button">
                        <label id="internal-off" for="internal">
                            <i class="fa fa-toggle-on fa-rotate-180"></i>
                        </label>
                        <label id="internal-on" for="internal">
                            <i class="fa fa-toggle-on active"></i>
                        </label>
                    </div>
                </div>
            </form>
        </section>
    <#if checks?size gt 0>
        <section class="Checks">
            <#list checks as check>
                <div id="check-${check.id}" class="Check">
                    <div class="Check-disable">
                        <form name="update-check" action="/check/${check.id}/update" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input name="name" type="hidden" value="${check.name}"/>
                            <input name="url" type="hidden" value="${check.url}"/>
                            <input name="interval" type="hidden" value="${check.interval}"/>
                            <input name="checkDisabled" type="hidden"
                                   value="<#if check.disabled?has_content>true<#else>false</#if>">
                            <input name="disable" type="hidden" value="true"/>
                            <button type="submit">
                                <#if check.disabled?has_content>
                                    <i class="fa fa-toggle-on fa-rotate-180"></i>
                                <#else>
                                    <i class="fa fa-toggle-on active"></i>
                                </#if>
                            </button>
                        </form>
                    </div>
                    <div class="Check-name">
                    ${check.name}
                    </div>
                    <div class="Check-status">
                        <#if check.disabled?has_content>
                            <span class="Check-disabled">disabled</span>
                        <#else>
                            <span class="Check-${check.status?lower_case}">${check.status}</span>
                        </#if>
                    </div>
                    <div class="Check-delete">
                        <form name="delete-check-${check.id}" action="/check/${check.id}/delete" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit">
                                <i class="fa fa-trash-o"></i>
                            </button>
                        </form>
                    </div>
                </div>
            </#list>
        </section>
    </#if>
    </div>
</main>
<footer class="Site-footer">
    <div class="Footer">
        <div class="Footer-credits">
            <span class="Footer-credit">
                copyright © 2016 codeaim
            </span>
        </div>
    </div>
</footer>
<#--<script src="/js/main.js"></script>-->
</body>
</html>