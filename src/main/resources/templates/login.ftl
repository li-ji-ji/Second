  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
错误信息：<h4 th:text="${msg}"></h4>
<form action="/login" method="post">
    <p>账号：<input type="text" name="username" value=""/></p>
    <p>密码：<input type="text" name="password" value=""/></p>
    <p><input type="submit" value="登录"/></p>
</form>
</body>
</html>