package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.format._
import play.api.data.Forms._

import com.mongodb.casbah.commons.Imports._

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
    )((name, address, phone, distance, tasteType, price, region) => Restuarant(new ObjectId, name, address, phone,
    distance, tasteType, price, region))((rest: Restuarant) => Some((rest.name, rest.address, rest.phone, rest.distance,
    rest.tasteType, rest.price, rest.region)))
  )

  val searchForm: Form[Conditions] = Form(
    mapping (
      "conditions" -> list[Condition] (
        mapping (
          "distance" -> optional(of(Formats.doubleFormat)),
          "taste" -> optional(text),
          "region" -> optional(text),
          "price" -> optional(of(Formats.doubleFormat))
        )(Condition.apply)(Condition.unapply)
      )
    )(Conditions.apply)(Conditions.unapply)
  )

  def index = Action {
    Ok(views.html.index(searchForm))
  }

  def form = Action {
    //Ok("restuarant Form")
    Ok(views.html.restuarant(restuarantForm, Taste.all, Region.all))
  }

  def all = Action {
    Ok(views.html.restuarant_all(Restuarant.all))
  }

  def add = Action { implicit request =>
    restuarantForm.bindFromRequest().fold(
      errors => BadRequest(views.html.restuarant(errors, Taste.all, Region.all)),
      restuarant => {
        Restuarant.add(restuarant)
        Redirect(routes.Application.add)
      }
    )
  }

  def update(id: String) = TODO

  def delete(id: String) = TODO



  def search() = Action {
    Ok("<select class='form-control'><option>a</option></select>")
  }
}