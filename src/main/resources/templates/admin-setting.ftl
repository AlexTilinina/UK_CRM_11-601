<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
    <div class="container">
        <h1>Настройки</h1>
        <div class="row mb-2">

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Список городов</h5>
                        <p class="card-text">Просмотр и редактирование списка городов</p>
                        <ul class="list-group list-group-flush">
                        <#list model.cities as city>
                            <li class="list-group-item">${city.name}</li>
                        </#list>
                        </ul>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addCity">
                            Добавить город
                        </button>
                    </div>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="addCity" tabindex="-1" role="dialog" aria-labelledby="addCityLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="addCityLabel">Добавить город</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form class="form" method="post" action="/admin/setting/add/city">
                                    <div class="form-group">
                                        <label class="left-label" for="inputCity">Введите название города:</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                              <i class="material-icons">home</i>
                                            </span>
                                            </div>
                                            <input type="text" class="form-control" name="city" id="inputCity" placeholder="Город">
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

            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Список должностей</h5>
                        <p class="card-text">Просмотр и редактирование списка должностей</p>
                        <ul class="list-group list-group-flush">
                        <#list model.positions as position>
                            <li class="list-group-item">${position.name}</li>
                        </#list>
                        </ul>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addPosition">
                            Добавить должность
                        </button>
                    </div>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="addPosition" tabindex="-1" role="dialog" aria-labelledby="addPositionLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="addPositionLabel">Добавить должность</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form class="form" method="post" action="/admin/setting/add/position">
                                    <div class="form-group">
                                        <label class="left-label" for="inputPosition">Введите название должности:</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                            <span class="input-group-text">
                                              <i class="material-icons">home</i>
                                            </span>
                                            </div>
                                            <input type="text" class="form-control" name="position" id="inputPosition" placeholder="Должность">
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


            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Список типов имущества</h5>
                        <p class="card-text">Просмотр и редактирование списка имущества</p>
                        <ul class="list-group list-group-flush">
                        <#list model.propertyTypes as type>
                            <li class="list-group-item">${type.type}</li>
                        </#list>
                        </ul>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addType">
                            Добавить тип имущества
                        </button>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="addType" tabindex="-1" role="dialog" aria-labelledby="addTypeLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addTypeLabel">Добавить должность</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="form" method="post" action="/admin/setting/add/property-type">
                                <div class="form-group">
                                    <label class="left-label" for="inputType">Введите название типа:</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                              <i class="material-icons">home</i>
                                            </span>
                                        </div>
                                        <input type="text" class="form-control" name="type" id="inputType" placeholder="Тип">
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


            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Список улиц</h5>
                        <p class="card-text">Просмотр и редактирование списка улиц</p>
                        <ul class="list-group list-group-flush">
                        <#list model.streets as street>
                            <li class="list-group-item">${street.city.name} - ${street.name}</li>
                        </#list>
                        </ul>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addStreet">
                            Добавить улицу
                        </button>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="addStreet" tabindex="-1" role="dialog" aria-labelledby="addStreetLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addStreetLabel">Добавить улицу</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="form" method="post" action="/admin/setting/add/street">

                                <div class="form-group bmd-form-group">
                                    <label for="selectCity" class="bmd-label-static">Выберите город:</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                                  <span class="input-group-text">
                                                    <i class="material-icons">home</i>
                                                  </span></div>
                                        <select name="city" class="form-control " id="selectCity">
                                                      <#list model.cities as city>
                                                          <#assign id>${city.id}</#assign>
                                                          <option value=${id}>${city.name}</option>
                                                      </#list>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="left-label" for="inputStreet">Введите название улицы:</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                              <i class="material-icons">home</i>
                                            </span>
                                        </div>
                                        <input type="text" class="form-control" name="street" id="inputStreet" placeholder="Улица">
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

<@footer.page></@footer.page>
