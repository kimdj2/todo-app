package helpers

object TodoHelper {
  import lib.model.Todo._

  def getStateOptions(): Seq[(String, String)] = {
    Seq(
      (Status.TODO.code.toString,     Status.TODO.name),
      (Status.PROGRESS.code.toString, Status.PROGRESS.name),
      (Status.END.code.toString,      Status.END.name)
    )
  }
}

