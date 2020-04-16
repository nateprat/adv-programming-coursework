package com.nateprat.core.action

import com.nateprat.core.map.RouteMapToRouteList
import com.nateprat.model.RouteMap
import com.nateprat.system.prompts.AppStrings
import com.nateprat.system.user.Menu
import com.nateprat.utils.{ListAndSelectRouteUtil, UserInput}

import scala.util.{Failure, Success, Try}

object DisplayRouteAction extends Action[Unit] {
  override def identifier(): String = "I"

  override def desc(): String = String.format(descString, "Display Route Information")

  override def act(map:RouteMap): Unit = {
    val rList = RouteMapToRouteList.map(map)
    println(ListAndSelectRouteUtil.run(rList).toString)
  }

}
