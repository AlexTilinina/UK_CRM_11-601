<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
      <div class="row">
        <div class="col-md-5 ml-auto mr-auto">
          <div class="card card-signup">
            <h2 class="card-title text-center">Редактирование</h2>
            <div class="card-body">
                <#assign id>${model.news.id}</#assign>
              <form class="form" method="post" action="/news/edit/${id}">
                  <div class="form-group">
                      <label class="left-label" for="inputTitle">Изменить название:</label>
                      <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                          </div>
                          <#assign title>${model.news.title}</#assign>
                          <input type="text" class="form-control" name="title" id="inputTitle" value="${title}">
                      </div>
                  </div>

                  <div class="form-group">
                      <label for="inputDescription">Изменить содержание:</label>
                      <div class="input-group" style="height: 50vh; width: auto;">
                          <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">create</i>
                      </span>
                          </div>
                          <#assign desc>${model.news.description}</#assign>
                          <textarea type="text" class="form-control" id="inputDescription" name="description">${desc}</textarea>
                      </div>
                  </div>
                  <div class="card-footer justify-content-center">
                      <button type="submit" class="btn btn-primary btn-lg btn-success">Сохранить</button>
                  </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
<@footer.page></@footer.page>
