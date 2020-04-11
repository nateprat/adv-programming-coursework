package com.nateprat.model

import com.nateprat.core.algorithm.{AlgorithmFactory, TotalDistanceForRouteAlgorithm}
import com.nateprat.core.map.RouteMapToRouteList

class Report(routeMap:RouteMap) {

  def getReport(): String = {
    val sb = new StringBuilder
    sb.append("Report of all Routes\nRoutes in descending order\n")
    val list = RouteMapToRouteList.map(routeMap)
    list
      .sortBy(TotalDistanceForRouteAlgorithm.calculate)
      .reverse
      .foreach(r => sb.append("Total Distance: " + TotalDistanceForRouteAlgorithm.calculate(r) + "km\t" + r.name_ + "\n"))
    sb.append("\n" + AlgorithmFactory.averageTotalDistancePlusAverageNoStages(list))
    sb.toString()
  }

}
