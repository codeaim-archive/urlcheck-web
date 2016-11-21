<#import "spring.ftl" as spring />
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
                <#if RequestParameters.locked??>
                    <div class="Login-message Login-error">
                        Please verify your account, <a href="/user/${RequestParameters.locked}/verification">click here</a> to resend the verification email
                    </div>
                </#if>
                <#if RequestParameters.logout??>
                    <div class="Login-message Login-success">
                        You have been logged out
                    </div>
                </#if>
                <#if RequestParameters.registered??>
                    <div class="Login-message Login-success">
                        Account registered. Verify your email to login, please check your inbox
                    </div>
                </#if>
                <#if RequestParameters.emailSent??>
                    <div class="Login-message Login-success">
                        Verification email sent, please check your inbox
                    </div>
                </#if>
                <#if RequestParameters.verified??>
                    <div class="Login-message Login-success">
                        Your account has been verified
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
                <button type="submit" class="Login-submit">
                    <i class="fa fa-sign-in"></i>Login
                </button>
            </form>
        </section>
        <section class="Login-accounts">
            <div class="title"><span>Need an account?</span></div>
            <a href="/register"><i class="fa fa-user"></i>Register</a>
            <#--<div class="title"><span>Or use</span></div>-->
            <#--<a href="/login/facebook"><i class="fa fa-facebook"></i>Facebook</a>-->
            <#--<a href="/login/google"><i class="fa fa-google-plus"></i>Google</a>-->
            <#--<a href="/login/github"><i class="fa fa-github"></i>GitHub</a>-->
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