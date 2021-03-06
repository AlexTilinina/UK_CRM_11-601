<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<@header.page></@header.page>
<main role="main" class="container">
    <div class="container">
      <div class="row">
        <div class="col-md-5 ml-auto mr-auto">
          <div class="card card-signup">
            <h2 class="card-title text-center">Создать новость</h2>
            <div class="card-body">
              <form class="form" method="post" action="/news/add">
                  <div class="form-group">
                      <label class="left-label" for="inputTitle">Введите название:</label>
                      <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text">
                              <i class="material-icons">edit</i>
                            </span>
                          </div>
                          <input type="text" class="form-control" name="title" id="inputTitle" placeholder="Название" required>
                      </div>
                  </div>

                  <div class="form-group">
                      <label for="inputDescription">Введите содержание:</label>
                      <div class="input-group" style="height: 50vh; width: auto;">
                          <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">create</i>
                      </span>
                          </div>
                          <textarea type="text" class="form-control" id="inputDescription" name="description" placeholder="Содержание" required></textarea>
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
