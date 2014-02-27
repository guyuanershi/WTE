package models

/**
 * Created by guyuanershi on 2/27/14.
 */
import com.novus.salat._
import com.novus.salat.dao._
import com.novus.salat.Context

import com.mongodb.casbah.commons.Imports._
import com.mongodb.casbah.MongoConnection

import play.api.Play.current
import play.api.PlayException

import db._

case class Region (
  _id: ObjectId = new ObjectId,
  name: String
)

//connect to default db & get regions collection
object RegionDAO extends SalatDAO[Region, ObjectId] (
  collection = MongoConnection()(
    current.configuration.getString("mongodb.default.db")
      .getOrElse(throw new PlayException("Configuration error", "Could not get default db setting"))
  )("regions")
)

object Region {
  def all = {
    RegionDAO.find(MongoDBObject.empty).toList
  }

  def Add(name: String): Option[ObjectId] = {
    RegionDAO.insert(new Region(name = name))
  }
}
