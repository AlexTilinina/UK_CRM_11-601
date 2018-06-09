<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-5 ml-auto mr-auto">
                <div class="card card-signup">
                    <h2 class="card-title text-center">Редактирование профиля</h2>
                    <div class="card-body">
                <#assign id>${model.user.id}</#assign>
                        <form class="form" method="post" action="/profile/edit/${id}">
                            <div class="form-group">
                                <label class="left-label" for="inputFirstName">Изменить имя:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                    </div>
                          <#assign firstName>${model.user.firstName}</#assign>
                                    <input type="text" class="form-control" name="firstName" id="inputFirstName" value="${firstName}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="left-label" for="inputSecondName">Изменить фамилию:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                    </div>
                          <#assign secondName>${model.user.secondName}</#assign>
                                    <input type="text" class="form-control" name="secondName" id="inputSecondName" value="${secondName}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="left-label" for="inputLastName">Изменить отчество:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                    </div>
                          <#assign lastName>${model.user.lastName}</#assign>
                                    <input type="text" class="form-control" name="lastName" id="inputLastName" value="${lastName}">
                                </div>
                            </div>

                  <#if (model.role == "EMPLOYEE")>

                       <div class="form-group bmd-form-group">
                           <label for="selectPosition" class="bmd-label-static">Изменить должность:</label>
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

                  <#elseif (model.role == "USER")>

                       <div class="form-group bmd-form-group">
                           <label for="selectCity" class="bmd-label-static">Изменить город:</label>
                           <div class="input-group">
                               <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">home</i>
                      </span></div>
                               <select name="city" class="form-control " id="selectCity">
                              <#list model.cities as city>
                                  <#assign cityId>${city.id}</#assign>
                                  <option value=${cityId}>${city.name}</option>
                              </#list>
                               </select>
                           </div>
                       </div>
                  </#if>
                            <div class="card-footer justify-content-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-success">Сохранить</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@footer.page></@footer.page>
