<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
    <main role="main" class="container">
        <div class="section section-signup">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 ml-auto mr-auto">
                        <div class="card card-signup">
                            <h2 class="card-title text-center">Авторизация</h2>
                            <form class="form" method="post" action="/sign-in">
                                <div class="card-body">
                                    <span class="bmd-form-group"><div class="input-group">
                                      <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">person</i>
                                        </span>
                                      </div>
                                      <input type="text" name="login" class="form-control" placeholder="Введите логин">
                                    </div></span>

                                    <span class="bmd-form-group"><div class="input-group">
                                      <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="material-icons">lock_outline</i>
                                        </span>
                                      </div>
                                      <input type="password" name="password" class="form-control" placeholder="Введите пароль">
                                    </div></span>


                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" name="remember-me">
                                            Запомнить меня
                                            <span class="form-check-sign">
                                                <span class="check"></span>
                                            </span>
                                        </label>
                                    </div>
                                </div>
                                <div class="card-footer justify-content-center">
                                    <button type="submit" href="#pablo" class="btn btn-primary btn-lg btn-success">Войти</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
<@footer.page></@footer.page>



