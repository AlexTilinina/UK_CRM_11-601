<#ftl encoding='UTF-8'>
<head>
</head>
<body>
ПРИВЕТ!
<div class="content-block">
    <form class="form-horizontal" action="/sign-in" method="post">
        <input name="login" placeholder="Логин">
        <input name="password" placeholder="Пароль">
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember-me">Запомнить
            </label>
        </div>
        <input type="submit">
    </form>
</div>
<a href="/sign-up/basic-user">Зарегистрироваться</a>
</body>