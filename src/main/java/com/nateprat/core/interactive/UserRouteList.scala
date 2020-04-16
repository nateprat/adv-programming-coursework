package com.nateprat.core.interactive

import java.util.StringJoiner

import com.nateprat.model.Route

import scala.collection.mutable

/**
  * RouteList for comments on personalised list of Routes with Comments
  */
class UserRouteList(name:String) {

  private val _name = name
  private val rMap = new mutable.HashMap[String, String]

  def addRoute(routeName:String, comment:String = ""): Unit = {
    rMap.addOne(routeName, comment)
  }

  def getRouteCommentMap(): mutable.HashMap[String, String] = {
    rMap
  }

  def getCommentForRoute(routeName:String): String = {
    rMap.find(_._1.contains(routeName)).get._2
  }

  override def toString: String = {
    val sj = new StringJoiner(",", "List-" + name + ",", "")
    rMap.foreachEntry((r, s) => sj.add(r + ":" + s))
    sj.toString
  }
}
