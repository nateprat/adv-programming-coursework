package com.nateprat.core.action

import com.nateprat.core.algorithm.AlgorithmFactory
import com.nateprat.core.map.RouteMapToRouteList
import com.nateprat.model.RouteMap
import com.nateprat.system.user.Menu

object RouteDescAction extends Action[Unit] {
  override def identifier(): String = "D"

  override def act(map:RouteMap): Unit = {
    val routeList = RouteMapToRouteList.map(map)
    routeList.foreach(route => println(AlgorithmFactory.totalDistanceAndNoStagesForRoute(route)))
  }

  override def desc(): String = {
    String.format(descString, "Route Description")
  }
}
