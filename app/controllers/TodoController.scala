/** to do sample project
  */

package controllers

import javax.inject._
import play.api.mvc._

import model.view.ViewValueTodoList
import service.TodoService
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class TodoController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def index() = Action.async { implicit req =>
    for {
      todoList <- TodoService.all
    } yield {
      val vv = ViewValueTodoList(todoList)
      Ok(views.html.todo.List(vv))
    }
  }
}
