<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <title>urlcheck.io</title>
    <meta name="description" content="A simple url monitor">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='https://fonts.googleapis.com/css?family=Lobster|Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <script src="https://use.fontawesome.com/b90ae1439a.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="Site">
<header class="Site-header">
    <div class="Header">
        <div class="Header-title">
            <i class="fa fa-clock-o"></i><span> urlcheck.</span><span class="Header-color">io</span>
        </div>
    <#--<div class="Header-action">-->
    <#--<p>signed in as <a href="#">GDownes</a> <i class="fa fa-user"></i> | <i class="fa fa-sign-out"></i> <a-->
    <#--href="#">sign out</a></p>-->
    <#--</div>-->
    </div>
</header>
<section class="Status <#if downCount gt 0>Status-down</#if>">
    <div class="Status-content">
    <#if downCount == 0>
        Up and running!
    <#else>
    ${downCount} down
    </#if>
    </div>
</section>
<main class="Site-content">
    <div class="Container">
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
<script src="/js/main.js"></script>
</body>
</html>