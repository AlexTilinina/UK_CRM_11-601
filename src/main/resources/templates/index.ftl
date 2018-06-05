<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>
    <div class="container">
        <h1>Новости</h1>
      <div class="row mb-2">
          <#list model.news as n>
        <div class="col-md-4">
          <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <h3 class="mb-0">
                <a class="text-dark" href="#">${n.title}</a>
              </h3>
              <div class="mb-1 text-muted">${n.date}</div>
                <#assign minititle=(n.description)>
                    <#if (minititle?length < 180)>
                        <p class="card-text mb-auto">${minititle}...    </p>
                    <#else>
                        <p class="card-text mb-auto">${minititle?substring(0, 181)}...</p>
                    </#if>
              <a href="#">Читать полностью</a>
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


