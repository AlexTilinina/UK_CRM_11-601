<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
<@header.page></@header.page>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main card ml-auto mr-auto">
            <div class="blog-post card-body">
                <#assign id>${model.news.id}</#assign>
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
                <h2 class="blog-post-title card-text">${model.news.title}</h2>
                <p class="blog-post-meta card-text">${model.news.date}</p>
                <p class="card-text">${model.news.description}</p>
        </div><!-- /.blog-main -->
    </div>

</main><!-- /.container -->

<@footer.page></@footer.page>


