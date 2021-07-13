package service

import lib.model.TodoCategory
import lib.model.TodoCategory._

import lib.persistence.onMySQL.TodoRepository
import lib.persistence.onMySQL.TodoCategoryRepository
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import model.item.TodoCategoryItem

object TodoCategoryService {
  def all(): Future[Seq[TodoCategoryItem]] = {
    for {
      todoCategoryList <- TodoCategoryRepository.all
    } yield todoCategoryList.map(category =>
      TodoCategoryItem(
        category.id,
        category.v.name,
        category.v.slug,
        category.v.color
      )
    )
  }
}
