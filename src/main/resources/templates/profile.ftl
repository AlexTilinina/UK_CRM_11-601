<#import "lib/header.ftl" as header>
<#import "lib/footer.ftl" as footer>
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
                                <#if model.user.employee??>
                                    <p class="card-text">Должность: ${model.user.employee.position.name}</p>
                                <#else >
                                    <p class="card-text">Город: ${model.user.owner.city.name}</p>
                                </#if>
                        <a href="#" class="btn btn-info">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<@footer.page></@footer.page>