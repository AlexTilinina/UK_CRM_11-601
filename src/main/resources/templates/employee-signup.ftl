<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-5 ml-auto mr-auto">
                <div class="card card-signup">
                    <h2 class="card-title text-center">Регистрация сотрудника</h2>
                    <div class="card-body">
                        <form class="form" method="post" action="/admin/sign-up">
                            <div class="form-group">
                                <label class="left-label" for="inputLogin">Введите логин:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">person</i>
                            </span>
                                    </div>
                                    <input type="text" class="form-control" name="login" id="inputLogin" placeholder="Логин">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputEmail">Введите email:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">mail</i>
                      </span>
                                    </div>
                                    <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPassword">Введите пароль:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">lock_outline</i>
                      </span>
                                    </div>
                                    <input type="password" name="password" id="inputPassword" placeholder="Пароль" class="form-control" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputFirstName">Введите имя:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">create</i>
                      </span>
                                    </div>
                                    <input type="text" class="form-control" id="inputFirstName" name="firstName" placeholder="Имя">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputSecondName">Введите фамилию:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">create</i>
                    </span>
                                    </div>
                                    <input type="text" class="form-control" id="inputSecondName" name="secondName" placeholder="Фамилия">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputLastName">Введите отчество:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="material-icons">create</i>
                    </span>
                                    </div>
                                    <input type="text" class="form-control" id="inputLastName" name="lastName" placeholder="Отчество">
                                </div>
                            </div>

                            <div class="form-group bmd-form-group">
                                <label for="selectPosition" class="bmd-label-static">Выберите должность:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="material-icons">home</i>
                  </span>
                                    </div>
                                    <select name="position" class="form-control " id="selectPosition">
                      <#list model.positions as position>
                          <option value=${position.name}>${position.name}</option>
                      </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="card-footer justify-content-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-success">Зарегистрироваться</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@footer.page></@footer.page>
