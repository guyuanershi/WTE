package models

/**
 * Created by guyuanershi on 2/24/14.
 */

//import TasteType._

import com.novus.salat._
import com.novus.salat.dao._
import com.novus.salat.Context

import com.mongodb.casbah.commons.Imports._
import com.mongodb.casbah.MongoConnection

import play.api.Play.current
import play.api.PlayException

import db._

case class Restuarant (
  _id:        ObjectId = new ObjectId,
  name:       String,
  address:    String,
  phone:      String,
  distance:   Double,
  tasteType:  String,
  price:      Double,
  region:     String
)

object RestuarantDAO extends SalatDAO[Restuarant, ObjectId] (
  collection = MongoConnection() (
    current.configuration.getString("mongodb.default.db")
      .getOrElse(throw new PlayException("Configuration error", "Could not get default db setting"))
    )("restuarants")
)

object Restuarant  {
  def all = RestuarantDAO.find(MongoDBObject.empty).toList

  def add(name:       String,
          address:    String,
          phone:      String,
          distance:   Double,
          tasteType:  String,
          price:      Double,
          region:     String): Option[ObjectId] = {
    RestuarantDAO.insert(new Restuarant(
                                       name = name,
                                       address = address,
                                       phone = phone,
                                       distance = distance,
                                       tasteType = tasteType,
                                       price = price,
                                       region = region
                                       ))
  }

  def one(id: String) = Nil

  def delete(id: String) = {}

  def update(id: String) = {}
}
