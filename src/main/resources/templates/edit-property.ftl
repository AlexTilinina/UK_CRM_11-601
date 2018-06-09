<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-5 ml-auto mr-auto">
                <div class="card card-signup">
                    <h2 class="card-title text-center">Редактирование имущества:</h2>
                    <div class="card-body">
                <#assign id>${model.property.id}</#assign>
                        <form class="form" method="post" action="/property/edit/${id}">

                            <div class="form-group bmd-form-group">
                                <label for="selectCity" class="bmd-label-static">Измените город:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                          <span class="input-group-text">
                            <i class="material-icons">home</i>
                          </span></div>
                                    <select name="city" class="form-control" id="selectCity">
                                        <option value="null">Не выбрано</option>
                              <#list model.cities as city>
                                  <#assign id>${city.id}</#assign>
                                  <option value=${id}>${city.name}</option>
                              </#list>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group bmd-form-group">
                                <label class="bmd-label-static" for="street-list">Введите название улицы:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">home</i>
                            </span>
                                    </div>
                                    <select name="street" class="form-control" id="street-list">
                                        <option value="null">Не выбрано</option>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group bmd-form-group">
                                <label for="selectType" class="bmd-label-static">Выберите тип имущества:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                              <span class="input-group-text">
                                <i class="material-icons">home</i>
                              </span></div>
                                    <select name="type" class="form-control" id="selectType">
                                        <option value="null">Не выбрано</option>
                              <#list model.types as type>
                                  <#assign id>${type.id}</#assign>
                                  <#if (model.property.type.type == type.type) >
                                        <option value=${id} selected>${type.type}</option>
                                  <#else >
                                        <option value=${id}>${type.type}</option>
                                  </#if>

                              </#list>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="left-label" for="inputHouseNumber">Введите номер дома:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">home</i>
                            </span>
                                    </div>
                          <#assign houseNumber>${model.property.houseNumber}</#assign>
                                    <input type="text" class="form-control" name="houseNumber" id="inputHouseNumber" value="${houseNumber}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="left-label" for="inputBuildingNumber">Введите корпус дома:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">home</i>
                            </span>
                                    </div>
                           <#assign buildingNumber>${model.property.buildingNumber}</#assign>
                                    <input type="text" class="form-control" name="BuildingNumber" id="inputBuildingNumber"  value="${buildingNumber}">
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="left-label" for="inputFlatNumber">Введите номер квартиры:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">home</i>
                            </span>
                                    </div>
                           <#assign flatNumber>${model.property.flatNumber}</#assign>
                                    <input type="text" class="form-control" name="flatNumber" id="inputFlatNumber"  value="${flatNumber}" >
                                </div>
                            </div>
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
<script src="/js/jquery.min.js" type="text/javascript"></script>
<script src="/js/ajax.js" type="text/javascript"></script>
<@footer.page></@footer.page>
