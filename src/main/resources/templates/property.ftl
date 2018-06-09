<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-10 ml-auto mr-auto">

                <div class="card text-center">
                    <div class="card-header card-header-info">
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a class="nav-link" href="/profile">Профиль</a>
                            </li>
                            <#if model.user.owner??>
                                <li class="nav-item">
                                    <a class="nav-link" href="/property">Имущество</a>
                                </li>
                            </#if>
                        </ul>
                    </div>
                    <div class="card-body">
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addProperty">
                            Добавить имущество
                        </button>

                            <#if model.properties??>
                                <#list model.properties as property>
                                    <h4 class="card-title">Имущество</h4>
                                    <#assign propertyId>${property.id}</#assign>
                                    <div class="dropdown ">
                                        <button class="btn btn-info btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Редактировать:</button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="/property/edit/${propertyId}">Изменить</a>
                                            <a class="dropdown-item" href="/property/delete/${propertyId}">Удалить</a>
                                        </div>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Город: ${property.city.name}</li>
                                        <li class="list-group-item">Улица: ${property.street.name}</li>
                                        <li class="list-group-item">Тип имущества: ${property.type.type}</li>
                                        <li class="list-group-item">Номер дома: ${property.houseNumber}</li>
                                        <li class="list-group-item">Корпус дома: ${property.buildingNumber}</li>
                                        <li class="list-group-item">Номер квартиры: ${property.flatNumber}</li>
                                    </ul>
                                </#list>
                            </#if>

                        <!-- Modal -->
                        <div class="modal fade" id="addProperty" tabindex="-1" role="dialog" aria-labelledby="addPropertyLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="addPropertyLabel">Добавить имущество</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form class="form" method="post" action="/property/add">

                                            <div class="form-group bmd-form-group">
                                                <label for="selectCity" class="bmd-label-static">Выберите город:</label>
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
                                                                      <option value=${id}>${type.type}</option>
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
                                                    <input type="text" class="form-control" name="houseNumber" id="inputHouseNumber" placeholder="Номер дома">
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
                                                    <input type="text" class="form-control" name="BuildingNumber" id="inputBuildingNumber" placeholder="Корпус" value="-">
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
                                                    <input type="text" class="form-control" name="flatNumber" id="inputFlatNumber"  value="-" placeholder="Номер квартиры">
                                                </div>
                                            </div>


                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Назад</button>
                                                <button type="submit" class="btn btn-primary">Сохранить</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="/js/jquery.min.js" type="text/javascript"></script>
<script src="js/ajax.js" type="text/javascript"></script>
<@footer.page></@footer.page>
