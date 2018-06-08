<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
    <div class="container">
        <h1>Новости</h1>
        <a href="/news/add" class="btn btn-primary btn-lg" role="button">Создать новость</a>
        <div class="row mb-2">
          <#list model.news as n>
              <div class="col-md-4">
                  <div class="card flex-md-row mb-4 box-shadow h-md-250">

                      <div class="card-body d-flex flex-column align-items-start">
                 <#assign id>${n.id}</#assign>
                <#if model.role??>
                    <#if (model.role == "EMPLOYEE") || (model.role == "ADMIN")>
                <div class="row">
                    <div class="col float-right">
                        <div class="dropdown ">
                            <button class="btn btn-info btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Редактировать:</button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="/news/edit/${id}">Изменить</a>
                                <a class="dropdown-item" href="/api/news/delete/${id}">Удалить</a>
                            </div>
                        </div>
                    </div>
                </div>
                    </#if>
                </#if>
                          <div class="row">
                              <div class="col">
                                  <h3 class="mb-0 mt-0">
                                      <a class="text-dark" href="news/${id}">${n.title}</a>
                                  </h3>
                                  <div class="mb-1 text-muted">${n.date}</div>
                <#assign minititle=(n.description)>
                    <#if (minititle?length < 100)>
                        <p class="card-text mb-auto">${minititle}...    </p>
                    <#else>
                        <p class="card-text mb-auto">${minititle?substring(0, 101)}...</p>
                    </#if>
                                  <a href="news/${id}">Читать полностью</a>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </#list>
        </div>
        <nav aria-label="Page navigation ">
            <ul class="pagination justify-content-center">
                <#assign page>${model.page}</#assign>
                <#if (model.page > 0)>
                <li class="page-item">
                    <a class="page-link" href="/news?page=${page?number - 1}&size=6" tabindex="-1">Предыдущая страница</a>
                </li>
                </#if>
                <#if model.stop>
                 <li class="page-item">
                     <a class="page-link" href="/news?page=${page?number + 1}&size=6">Следующая страница</a>
                 </li>
                </#if>
            </ul>
        </nav>
    </div>
<@footer.page></@footer.page>
