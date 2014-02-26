package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.format._
import play.api.data.Forms._
import models._

object Application extends Controller {

  //play.api.templates.Html
  /**
   * Contact Form definition.
   */
  val restuarantForm: Form[Restuarant] = Form(

    // Defines a mapping that will handle restuarant values
    mapping(
      "name" -> nonEmptyText,
      "address" -> nonEmptyText,
      "phone" -> nonEmptyText,
      "distance" -> of(Formats.doubleFormat),
      "tasteType" -> nonEmptyText,
      "price" -> of(Formats.doubleFormat),
      "region" -> nonEmptyText
    )(Restuarant.apply)(Restuarant.unapply)
  )

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def form = Action {
    //Ok("restuarant Form")
    Ok(views.html.restuarant(restuarantForm))
  }

  def all = Action {
    Ok("all restuarants")
  }

  def add = Action { implicit request =>
    restuarantForm.bindFromRequest().fold(
      errors => BadRequest(views.html.restuarant(errors)),
      restuarant => {
        Redirect(routes.Application.all)
      }
    )
  }

  def update(id: String) = TODO

  def delete(id: String) = TODO


}