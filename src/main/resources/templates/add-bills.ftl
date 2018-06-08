<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-5 ml-auto mr-auto">
                <div class="card card-signup">
                    <h2 class="card-title text-center">Оплатить</h2>
                    <div class="card-body">
                        <form class="form" method="post" action="/payment" >


                            <div class="form-group bmd-form-group">
                                <label for="selectProperty" class="bmd-label-static">Выберите имущество:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                          <span class="input-group-text">
                            <i class="material-icons">home</i>
                          </span></div>
                                    <select name="propertyId" class="form-control" id="selectProperty">
                                        <option value="null">Не выбрано</option>
                              <#list model.properties as property>
                                  <#assign id>${property.id}</#assign>
                                  <option value=${id}>${property.type.type}: ${property.street.name} ${property.houseNumber}</option>
                              </#list>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group bmd-form-group">
                                <label for="selectService" class="bmd-label-static">Выберите услугу:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                          <span class="input-group-text">
                            <i class="material-icons">home</i>
                          </span></div>
                                    <select name="serviceType" class="form-control" id="selectService">
                                        <option value="null">Не выбрано</option>
                              <#list model.services as service>
                                  <#assign id>${service.id}</#assign>
                                  <option value=${id}>${service.type}</option>
                              </#list>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="left-label" for="inputSum">Введите сумму для оплаты:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                    </div>
                                    <input type="text" class="form-control" name="sum" id="inputSum" placeholder="Сумма" required>
                                </div>
                            </div>


                            <div class="card-footer justify-content-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-success">Оплатить</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@footer.page></@footer.page>
