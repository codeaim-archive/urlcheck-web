<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <title>urlcheck.io</title>
    <meta name="description" content="A simple url monitor">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <script src="https://use.fontawesome.com/b90ae1439a.js"></script>
<#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="Site">
<header class="Site-header">
    <div class="Header">
        <div class="Header-title">
            <i class="icon-urlcheck"></i><span> urlcheck.</span><span class="Header-color">io</span>
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
        <section class="Check-create">
            <form name="check" action="/check" method="post">
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
                            <input type="text" name="address" title="Url" placeholder="www.website.com"/>
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
                            <#--<i class="fa fa-gears"></i>-->
                                <button type="submit">
                                    <i class="fa fa-save"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
    <#if checks?size gt 0>
        <section class="Checks">
            <#list checks as check>
                <div class="Check">
                    <div class="Check-name">
                    ${check.name}
                    </div>
                    <div class="Check-status">
                        <span class="Check-${check.status?lower_case}">${check.status}</span>
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