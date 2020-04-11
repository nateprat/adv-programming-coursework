package com.nateprat.system.user

import com.nateprat.core.algorithm.AlgorithmFactory
import com.nateprat.core.map.RouteMapToRouteList

object RouteDescAction extends Action {
  override def identifier(): String = "D"

  override def act(): Unit = {
    val routeList = RouteMapToRouteList.map(Menu.routeMap)
    routeList.foreach(route => println(AlgorithmFactory.totalDistanceAndNoStagesForRoute(route)))
  }

  override def desc(): String = {
    String.format(descString, "Route Description")
  }
}
