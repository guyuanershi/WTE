package models

/**
 * Created by guyuanershi on 2/26/14.
 */

import com.novus.salat._
import com.novus.salat.dao._
import com.novus.salat.Context

import com.mongodb.casbah.commons.Imports._
import com.mongodb.casbah.MongoConnection

import play.api.Play.current
import play.api.PlayException

import db._

case class Taste (_id: ObjectId = new ObjectId,
  name: String
)

//connect to default db & get tastes collection
object TasteDAO extends SalatDAO[Taste, ObjectId] (
  collection = MongoConnection()(
    current.configuration.getString("mongodb.default.db")
      .getOrElse(throw new PlayException("Configuration error", "Could not get default db setting"))
  )("tastes")
)

object Taste {
  def all = {
    TasteDAO.find(MongoDBObject.empty).toList
  }

  def Add(name: String): Option[ObjectId] = {
    TasteDAO.insert(new Taste(name = name))
  }
}