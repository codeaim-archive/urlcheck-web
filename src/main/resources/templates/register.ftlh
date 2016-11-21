<html class="no-js" lang="en" xmlns="http://www.w3.org/1999/html">
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
    </div>
</header>
<main class="Site-content">
    <div class="Container">
        <section class="Register">
            <form name="register" action="/register" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="title">
                    <span>Register</span>
                </div>
                <#if RequestParameters.error??>
                    <div class="Register-message Register-error">
                        Problem with registration
                    </div>
                </#if>
                <div class="Register-username">
                    <label>Username</label>
                    <input type="text" name="username" title="Username" placeholder="username"/>
                </div>
                <div class="Register-email">
                    <label>Email</label>
                    <input type="email" name="email" title="Email" placeholder="example@example.com"/>
                </div>
                <div class="Register-password">
                    <label>Password</label>
                    <input type="password" name="password" title="Password" placeholder="password"/>
                </div>
                <div class="Register-confirm-password">
                    <label>Confirm password</label>
                    <input type="password" name="confirmPassword" title="Confirm password" placeholder="Confirm password"/>
                </div>
                <button type="submit" class="Register-submit">
                    <i class="fa fa-user"></i>Register
                </button>
            </form>
        </section>
        <section class="Login-accounts">
            <div class="title"><span>Got an account?</span></div>
            <a href="/login"><i class="fa fa-sign-in"></i>Login</a>
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