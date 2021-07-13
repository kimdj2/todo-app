package service

import lib.model.Todo
import lib.model.Todo._
import lib.model.TodoCategory
import lib.model.TodoCategory._

import lib.persistence.onMySQL.TodoRepository
import lib.persistence.onMySQL.TodoCategoryRepository
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import model.item.TodoList
import model.item.TodoItem
import model.item.TodoCategoryItem


object TodoService {
  def all(): Future[Seq[TodoList]] = {
    for {
        todoList <- TodoRepository.all
        todoCategoryList <- TodoCategoryRepository.all
    } yield {
        for {
            todo <- todoList
        } yield {
            val category = todoCategoryList.find(_.id == todo.v.categoryId).map(category => TodoCategoryItem(category.id, category.v.name, category.v.slug, category.v.color))
            TodoList(TodoItem(todo.id, todo.v.title, todo.v.body, todo.v.state), category)
        }
    }
  }
}
