package models

/**
 * Created by guyuanershi on 2/24/14.
 */

//import TasteType._

case class Restuarant (
  name:       String,
  address:    String,
  phone:      String,
  distance:   Double,
  stateType:  String,
  price:      Double,
  region:     String
)

object Restuarant {
  def all = Nil

  def one(id: String) = Nil

  def delete(id: String) = {}

  def update(id: String) = {}
}
