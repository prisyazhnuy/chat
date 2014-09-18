<html>
<head>
    <title>Log in</title>
</head>
<body>
${password}
<form name="user" id="user" action="<@spring.url "/login" />" method="POST">
    <input id="login" name="login" placeholder="login" type="text">
    <input id="password" name="password" placeholder="Password" title="password" type="password">

    <input id="signin_submit" value="Sign in" type="submit" name="submit"></p>
</form>
</body>
</html>
