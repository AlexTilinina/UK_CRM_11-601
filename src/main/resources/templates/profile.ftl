<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-10 ml-auto mr-auto">

                <div class="card text-center">
                    <div class="card-header card-header-info">
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a class="nav-link" href="/profile">Профиль</a>
                            </li>
                            <#if model.user.owner??>
                                <li class="nav-item">
                                    <a class="nav-link" href="/property">Имущество</a>
                                </li>
                            </#if>
                        </ul>
                    </div>
                    <div class="card-body">
                        <h4 class="card-title">${model.user.firstName} ${model.user.secondName} ${model.user.lastName}</h4>
                                <#if (model.role == "EMPLOYEE")>
                                    <p class="card-text">Должность: ${model.user.employee.position.name}</p>
                                <#elseif (model.role == "USER")>
                                    <p class="card-text">Город: ${model.user.owner.city.name}</p>
                                <#else >
                                </#if>
                            <#assign id>${model.user.id}</#assign>
                        <a href="/profile/edit/${id}" class="btn btn-info">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@footer.page></@footer.page>