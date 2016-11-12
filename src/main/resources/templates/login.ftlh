<html class="no-js" lang="en" xmlns="http://www.w3.org/1999/html">
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
    <#--<div class="Header-action">-->
    <#--<p>signed in as <a href="#">GDownes</a> <i class="fa fa-user"></i> | <i class="fa fa-sign-out"></i> <a-->
    <#--href="#">sign out</a></p>-->
    <#--</div>-->
    </div>
</header>
<main class="Site-content">
    <div class="Container">
        <section class="Login">
            <form name="login" action="/login" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="title"><span>Login</span></div>
                <#if RequestParameters.error??>
                    <div class="Login-message Login-error">
                        Invalid username or password
                    </div>
                </#if>
                <#if RequestParameters.logout??>
                    <div class="Login-message Login-success">
                        You have been logged out
                    </div>
                </#if>
                <div class="Login-email">
                    <label>Email / Username</label>
                    <input type="text" name="username" title="Email / Username" placeholder="example@example.com"/>
                </div>
                <div class="Login-password">
                    <label>Password</label>
                    <input type="password" name="password" title="Password" placeholder="password"/>
                </div>
                <div class="Login-submit">
                    <input type="submit" value="Login">
                </div>
            </form>
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
<#--<script src="/js/main.js"></script>-->
</body>
</html>