<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-5 ml-auto mr-auto">
                <div class="card card-signup">
                    <h2 class="card-title text-center">Внести показания</h2>
                    <div class="card-body">
                        <form class="form" method="post" action="/meters/add" >

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

                            <div class="form-group">
                                <label class="left-label" for="inputService">Выбранная услуга:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                    </div>
                          <#assign id>${model.service.id}</#assign>
                          <#assign type>${model.service.type}</#assign>
                                    <input type="text" class="form-control" name="serviceId" id="inputService" value="${id}" readonly="readonly" hidden>
                                    <input type="text" class="form-control" id="inputService" value="${type}" readonly="readonly">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="left-label" for="inputSum">Введите показание счетчика:</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                                    </div>
                                    <input type="number" class="form-control" name="number" id="inputSum" placeholder="Показание" required>
                                </div>
                            </div>


                            <div class="card-footer justify-content-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-success">Внести</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@footer.page></@footer.page>
