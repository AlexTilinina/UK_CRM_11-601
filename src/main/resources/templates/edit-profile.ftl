<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
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

                  <#if employee??>

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

                  <#else >

                       <div class="form-group bmd-form-group">
                           <label for="selectCity" class="bmd-label-static">Изменить город:</label>
                           <div class="input-group">
                               <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">home</i>
                      </span></div>
                               <select name="city" class="form-control " id="selectCity">
                              <#list model.cities as city>
                                  <option value=${city.name}>${city.name}</option>
                              </#list>
                               </select>
                           </div>
                       </div>

                        <div class="form-group bmd-form-group">
                            <label for="selectStreet" class="bmd-label-static">Изменить улицу:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                              <span class="input-group-text">
                                <i class="material-icons">home</i>
                              </span>
                                </div>
                                <select name="street" class="form-control" id="selectStreet">
                                    <option>Не выбрано</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="left-label" for="inputHouseNumber">Изменить номер дома:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                </div>
                          <#assign houseNumber>${model.user.propertyOwner.property.houseNumber}</#assign>
                                <input type="number" class="form-control" name="houseNumber" id="inputHouseNumber" value="${houseNumber}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="left-label" for="inputBuildingNumber">Изменить корпус:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                </div>
                          <#assign buildingNumber>${model.user.propertyOwner.property.buildingNumber}</#assign>
                                <input type="number" class="form-control" name="buildingNumber" id="inputBuildingNumber" value="${buildingNumber}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="left-label" for="inputFlatNumber">Изменить номер квартиры:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                </div>
                          <#assign flatNumber>${model.user.propertyOwner.property.flatNumber}</#assign>
                                <input type="number" class="form-control" name="flatNumber" id="inputFlatNumber" value="${flatNumber}">
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
