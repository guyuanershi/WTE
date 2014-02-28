package models

import models.Restuarant

/**
 * Created by guyuanershi on 2/28/14.
 */
case class Conditions (conds: List[Condition])

case class Condition (
                       distance: Option[Double],
                       taste: Option[String],
                       region: Option[String],
                       price: Option[Double])

object Condition {

}

object Conditions {

}
