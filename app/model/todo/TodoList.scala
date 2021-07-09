package model

import model._
import lib.model.Todo
import lib.model.Todo._


// TodoListのviewvalue
case class ViewValueTodoList(
  viewValue:  ViewValueCommon,
  todoList:   Seq[Todo.EmbeddedId]
)
