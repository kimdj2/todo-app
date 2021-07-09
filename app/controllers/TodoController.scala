/** to do sample project
  */

package controllers

import javax.inject._
import play.api.mvc._

import model.ViewValueTodoList
import model.ViewValueHome
import lib.persistence.onMySQL.TodoRepository
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class TodoController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def index() = Action.async { implicit req =>
    for {
      todoList <- TodoRepository.all
    } yield {
      val vv = ViewValueTodoList(
        viewValue = ViewValueHome(
          title = "TODO LIST",
          cssSrc = Seq("main.css"),
          jsSrc = Seq("main.js")
        ),
        todoList = todoList
      )
      Ok(views.html.todo.List(vv))
    }
  }
}
