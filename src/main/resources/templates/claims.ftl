<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
    <div class="container">
        <h1>Ваши заявки</h1>
        <div class="row">
            <div class="col-3">
                <div class="card card-body mb-2">
                    <h3>Фильтрация</h3>
                    <form action="/claims/filter" method="post">
                        <div class="form-group">
                            <label for="filter">Сортировать заявки по статусу:</label>
                            <select class="form-control" id="filter" name="filter">
                                <option value="NEW">Новая</option>
                                <option value="IN_PROCESS">В процессе</option>
                                <option value="FEEDBACK">Обратная связь</option>
                                <option value="CLOSED">Закрыта</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-info brn-sm">Применить</button>
                    </form>
                </div>

                <div class="card card-body mb-2">
                    <h3>Фильтрация</h3>
                    <form action="/claims/filter" method="post">
                        <div class="form-group">
                            <label for="filter">Сортировать заявки по ответу:</label>
                            <select class="form-control" id="filter" name="filter">
                                <option value="answer">С ответом</option>
                                <option value="not_answer">Без ответа</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-info brn-sm">Применить</button>
                    </form>
                </div>
            </div>
            <div class="col-9">
                <div class="row mb-2">
                 <#if model.claims??>
                  <#list model.claims as claim>
                      <div class="col-md-6">
                          <div class="card">
                              <div class="card-body">
                                  <h4 class="card-title">${claim.title}</h4>

                                  <#if (claim.state == 'NEW')>
                                        <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-danger"> Новая</span></h6>
                                  <#elseif (claim.state == 'IN_PROCESS')>
                                        <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-warning"> В процессе</span></h6>
                                  <#elseif (claim.state == 'FEEDBACK')>
                                        <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-info"> Обратная связь</span></h6>
                                  <#else>
                                        <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-success"> Закрыта</span></h6>
                                  </#if>

                                  <p class="card-text">${claim.description}</p>

                                  <#if model.employee?? >
                                    <h6 class="card-subtitle mb-2 text-muted">${claim.propertyOwner.user.firstName} ${claim.propertyOwner.user.secondName}</h6>
                                  </#if>

                                  <#if claim.answer??>
                                      <#assign claim_id>${claim.id}</#assign>
                                    <button class="btn btn-info btn-sm" type="button" data-toggle="collapse" data-target="#answerCollapse${claim_id}" aria-expanded="false" aria-controls="answerCollapse">
                                        Ответ на заявку
                                    </button>
                                    <div class="collapse" id="answerCollapse${claim_id}">
                                        <div class="card card-body">${claim.answer}</div>
                                        <h6 class="card-subtitle mb-2 text-muted">${claim.employee.user.firstName} ${claim.employee.user.secondName}</h6>
                                    </div>

                                  <#else>

                                      <#if model.employee??>
                                          <#assign id>${claim.id}</#assign>

                                      <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#addAnswer">
                                          Ответить на заявку
                                      </button>
                                       <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#addState">
                                           Сменить статус
                                       </button>
                                        <div class="modal fade" id="addAnswer" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Добавить ответ</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form class="form" method="post" action="/claims/add/answer/${id}">
                                                            <div class="form-group">
                                                                <label for="inputAnswer">Введите ответ</label>
                                                                <div class="input-group" style="height: 50vh; width: auto;">
                                                                    <div class="input-group-prepend">
                                                                  <span class="input-group-text">
                                                                    <i class="material-icons">create</i>
                                                                  </span>
                                                                    </div>
                                                                    <textarea type="text" class="form-control" id="inputAnswer" name="answer" placeholder="Ответ"></textarea>
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
                                        <div class="modal fade" id="addState" tabindex="-1" role="dialog" aria-labelledby="addStateLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="addStateLabel">Сменить статус заявки:</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form class="form" method="post" action="/claims/add/state/${id}">
                                                            <div class="form-group">
                                                                <label for="filter">Выберите статус:</label>
                                                                <select class="form-control" id="filter" name="state">
                                                                    <option value="NEW">Новая</option>
                                                                    <option value="IN_PROCESS">В процессе</option>
                                                                    <option value="FEEDBACK">Обратная связь</option>
                                                                    <option value="CLOSED">Закрыть</option>
                                                                </select>
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
                                      <#else>

                                         <button class="btn btn-secondary btn-sm" type="button" disabled>
                                             Нет ответа
                                         </button>

                                      </#if>

                                  </#if>

                              </div>
                          </div>
                      </div>
                  </#list>
                 <#else>
                        <h2>Нет заявок</h2>
                 </#if>
                </div>
            </div>
        </div>

    </div>

<@footer.page></@footer.page>
