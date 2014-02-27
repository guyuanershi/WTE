package controllers

/**
 * Created by guyuanershi on 2/26/14.
 */

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.format._
import play.api.data.Forms._
import models._

object TasteController extends Controller {

  val tasteForm = Form(
    "name" -> nonEmptyText
  )

  def all = Action {
    Ok(views.html.taste_all(Taste.all))
  }

  def add = Action { implicit request =>
    tasteForm.bindFromRequest().fold(
      errors => BadRequest(views.html.taste(errors)),
      taste => {
        Taste.Add(taste)
        Redirect(routes.TasteController.all)
      }
    )
  }

  def form = Action {
    Ok(views.html.taste(tasteForm))
  }

  def delete(id: String) = TODO
}
