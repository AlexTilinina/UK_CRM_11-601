<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
    <div class="container">
        <h1>Показания счетчиков</h1>
        <div class="row mb-2">

            <div class="col-md-4">
                <div class="card flex-md-row mb-4 box-shadow  ">
                    <div class="card-body d-flex flex-column align-items-start">
                        <div class="row">
                            <div class="col">
                                <h5 class="mb-0 mt-0">
                                    <a class="text-dark">Услуга: Внести показания воды</a>
                                </h5>
                                <#if model.role??>
                                    <#if (model.role == "USER")>
                                        <a href="/meters/add/water" class="btn btn-info">Внести</a>
                                    </#if>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card flex-md-row mb-4 box-shadow  ">
                    <div class="card-body d-flex flex-column align-items-start">
                        <div class="row">
                            <div class="col">
                                <h5 class="mb-0 mt-0">
                                    <a class="text-dark">Услуга: Внести показания электричества</a>
                                </h5>
                                <#if model.role??>
                                    <#if (model.role == "USER")>
                                        <a href="/meters/add/electricity" class="btn btn-info">Внести</a>
                                    </#if>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card flex-md-row mb-4 box-shadow  ">
                    <div class="card-body d-flex flex-column align-items-start">
                        <div class="row">
                            <div class="col">
                                <h5 class="mb-0 mt-0">
                                    <a class="text-dark">Услуга: Внести показания газа</a>
                                </h5>
                                <#if model.role??>
                                    <#if (model.role == "USER")>
                                        <a href="/meters/add/gas" class="btn btn-info">Внести</a>
                                    </#if>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mb-2">
          <#list model.meters as meter>
              <div class="col-md-4">
                  <div class="card flex-md-row mb-4 box-shadow  ">

                      <div class="card-body d-flex flex-column align-items-start">
                 <#assign id>${meter.id}</#assign>
                          <div class="row">
                              <div class="col">
                                  <h5 class="mb-0 mt-0">
                                      <a class="text-dark">Услуга: ${meter.serviceType.type}</a>
                                  </h5>
                                  <div class="mb-1 text-muted">${meter.date}</div>
                                  <p>Пользователь: ${model.user.firstName} ${model.user.secondName} ${model.user.lastName}</p>
                                  <p>Показания: ${meter.number}</p>
                                  <p>Имущество:
                                  <ul class="list-group list-group-flush">
                                      <li class="list-group-item">Город: ${meter.property.city.name}</li>
                                      <li class="list-group-item">Улица: ${meter.property.street.name}</li>
                                      <li class="list-group-item">Тип имущества: ${meter.property.type.type}</li>
                                      <li class="list-group-item">Номер дома: ${meter.property.houseNumber}</li>
                                      <li class="list-group-item">Корпус дома: ${meter.property.buildingNumber}</li>
                                      <li class="list-group-item">Номер квартиры: ${meter.property.flatNumber}</li>
                                  </ul>
                                  </p>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </#list>
        </div>
    </div>
<@footer.page></@footer.page>


