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

  val tasteForm: Form[Taste] = Form(
    mapping(
      "name" -> nonEmptyText
    )(Taste.apply)(Taste.unapply)
  )

  def all = TODO

  def add = TODO

  def form = Action {
    Ok(views.html.taste(tasteForm))
  }

  def delete(id: String) = TODO
}
