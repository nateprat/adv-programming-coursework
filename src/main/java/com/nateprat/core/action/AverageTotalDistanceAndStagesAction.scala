package com.nateprat.core.action

import com.nateprat.core.algorithm.AlgorithmFactory
import com.nateprat.core.map.RouteMapToRouteList
import com.nateprat.system.user.Menu

object AverageTotalDistanceAndStagesAction extends Action[Unit] {
  override def identifier(): String = "A"

  override def desc(): String = String.format(descString, "Average Total Distance and Stages of Routes")

  override def act(): Unit = {
    println(AlgorithmFactory.averageTotalDistancePlusAverageNoStages(RouteMapToRouteList.map(Menu.routeMap)))
  }
}
