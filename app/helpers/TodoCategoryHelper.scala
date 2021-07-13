package helpers

object TodoCategoryHelper {
  import lib.model.TodoCategory._

  def getStateStyle(color: Color): String = color match {
    case Color.RED    => "todo-list__category-name--red"
    case Color.YELLOW => "todo-list__category-name--yellow"
    case Color.BLUE   => "todo-list__category-name--blue"
  }
}
