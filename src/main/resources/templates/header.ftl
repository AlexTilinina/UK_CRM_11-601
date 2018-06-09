<#macro page>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../static/icon/favicon.ico">

    <title>CRM Project</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=vvvPlayfair+Display:700,900" rel="stylesheet">
    <link href="/css/blog.css" rel="stylesheet">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="/css/material-kit.css?v=2.0.3" rel="stylesheet" />
    <link href="/css/custom.css" rel="stylesheet">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-success">
        <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" >
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/news">
                            <i class="material-icons">explore</i>
                            Новости</span></a>
                    </li>

                    <#if model??>
                        <#if model.role??>

                            <#if (model.role == "USER")>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="material-icons">question_answer</i>
                                    Заявки</a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="/claims/add">Создать</a>
                                    <a class="dropdown-item" href="/claims">Мои заявки</a>
                                </div>
                            </li>


                            <#elseif (model.role == "EMPLOYEE") >

                             <li class="nav-item">
                                 <a class="nav-link" href="/claims">
                                     <i class="material-icons">question_answer</i>
                                     Заявки</span></a>
                             </li>

                            <#else>
                            <li class="nav-item">
                                <a class="nav-link" href="/claims">
                                    <i class="material-icons">question_answer</i>
                                    Заявки</span></a>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="" id="editLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="material-icons">edit</i>
                                    Настройки</a>
                                <div class="dropdown-menu" aria-labelledby="editLink">
                                    <a class="dropdown-item" href="/admin/sign-up">Добавить сотрудника</a>
                                    <a class="dropdown-item" href="/admin/setting">Общие настройки</a>
                                </div>
                            </li>


                            </#if>

                        <#else >

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="material-icons">question_answer</i>
                                    Заявки</a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="/claims/add">Создать</a>
                                    <a class="dropdown-item" href="/claims">Мои заявки</a>
                                </div>
                            </li>


                        </#if>
                    </#if>

                    <li class="nav-item">
                        <a class="nav-link" href="/bills">
                            <i class="material-icons">account_balance_wallet</i>
                            Оплата</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/meters">
                            <i class="material-icons">settings</i>
                            Показания счетчиков</a>
                    </li>

                </ul>
                <ul class="navbar-nav ml-auto">
                    <#if model??>
                        <#if model.role??>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="material-icons">account_circle</i>
                                    Профиль
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="/profile">Профиль</a>
                                    <a class="dropdown-item" href="/logout">Выйти</a>
                                </div>
                            </li>
                        <#else>
                            <li class="nav-item">
                                <a class="nav-link" href="/sign-in">
                                    Войти</span></a>
                            </li>
                        </#if>
                    </#if>

                </ul>
            </div>
        </div>
    </nav>
</header>
</#macro>