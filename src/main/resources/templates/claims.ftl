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
                                <option value="IN_PROGRESS">В процессе</option>
                                <option value="FEEDBACK">Обратная связь</option>
                                <option value="CLOSED">Закрыть</option>
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
                                    <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-danger">Новая</span></h6>
                                <#elseif (claim.state == 'IN_PROGRESS')>
                                    <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-warning">В процессе</span></h6>
                                <#elseif (claim.state == 'FEEDBACK')>
                                    <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-info">Обратная связь</span></h6>
                                <#else>
                                    <h6 class="card-subtitle mb-2 text-muted">Статус заявки:<span class="text-success">Закрыта</span></h6>
                                </#if>


                                  <p class="card-text">${claim.description}</p>
                                 <#if claim.answer??>
                                    <button class="btn btn-info btn-sm" type="button" data-toggle="collapse" data-target="#answerCollapse" aria-expanded="false" aria-controls="answerCollapse">
                                        Ответ на заявку
                                    </button>
                                    <div class="collapse" id="answerCollapse">
                                        <div class="card card-body">${claim.answer}</div>
                                        <h6 class="card-subtitle mb-2 text-muted">${claim.employee.user.firstName} ${claim.employee.user.secondName}</h6>
                                    </div>
                                 <#else>
                                     <button class="btn btn-secondary btn-sm" type="button" disabled>
                                         Нет ответа
                                     </button>
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