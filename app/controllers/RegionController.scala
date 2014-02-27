package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.format._
import play.api.data.Forms._
import models._

/**
 * Created by guyuanershi on 2/27/14.
 */
object RegionController extends Controller{
  val regionForm = Form(
    "name" -> nonEmptyText
  )

  def all = Action {
    Ok(views.html.region_all(Region.all))
  }

  def add = Action { implicit request =>
    regionForm.bindFromRequest().fold(
      errors => BadRequest(views.html.region(errors)),
      region => {
        Region.Add(region)
        Redirect(routes.RegionController.all)
      }
    )
  }

  def form = Action {
    Ok(views.html.region(regionForm))
  }

  def delete(id: String) = TODO
}
