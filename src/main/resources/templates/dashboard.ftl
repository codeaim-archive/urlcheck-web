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
        <p class="Check-create-title">Create your first check</p>
        <section class="Check-create">
            <div class="Check-name">
                <input type="text" title="Name" placeholder="name"/>
            </div>
            <div class="Check-url">
                <input type="url" title="Url" placeholder="http://www.example.com"/>
            </div>
            <div class="Check-interval">
                <input type="number" title="Interval" min="1" max="60" value="5"/>
            </div>
            <div class="Check-submit">
                <input type="submit" value="Create Check">
            </div>
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