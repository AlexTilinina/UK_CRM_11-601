<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
    <div class="container">
        <h1>Произведенные оплаты</h1>
        <#if model.role??>
            <#if (model.role == "USER")>
                <a href="/payment" class="btn btn-primary btn-lg" role="button">Оплатить услугу</a>
            </#if>
        </#if>
        <div class="row mb-2">
          <#list model.bills as bill>
              <div class="col-md-4">
                  <div class="card flex-md-row mb-4 box-shadow  ">

                      <div class="card-body d-flex flex-column align-items-start">
                 <#assign id>${bill.id}</#assign>
                          <div class="row">
                              <div class="col">
                                  <h5 class="mb-0 mt-0">
                                      <a class="text-dark">Номер счета: ${bill.billNumber}</a>
                                  </h5>
                                  <div class="mb-1 text-muted">${bill.payment.date}</div>
                                  <p>Имущество:
                                  <ul class="list-group list-group-flush">
                                      <li class="list-group-item">Город: ${bill.property.city.name}</li>
                                      <li class="list-group-item">Улица: ${bill.property.street.name}</li>
                                      <li class="list-group-item">Тип имущества: ${bill.property.type.type}</li>
                                      <li class="list-group-item">Номер дома: ${bill.property.houseNumber}</li>
                                      <li class="list-group-item">Корпус дома: ${bill.property.buildingNumber}</li>
                                      <li class="list-group-item">Номер квартиры: ${bill.property.flatNumber}</li>
                                  </ul>
                                  </p>
                                  <p>Сервис: ${bill.serviceType.type}</p>
                                  <p>Сумма: ${bill.sum}</p>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </#list>
        </div>
    </div>
<@footer.page></@footer.page>
