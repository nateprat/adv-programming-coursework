package com.nateprat.model

import com.nateprat.core.algorithm.{AlgorithmFactory, TotalDistanceForRouteAlgorithm}

class Report(routeList:List[Route]) {

  private val list = routeList;
  private val algoFact = new AlgorithmFactory

  def getReport(): String = {
    val sb = new StringBuilder
    sb.append("Report of all Routes\nRoutes in descending order\n")
    list.sortBy(TotalDistanceForRouteAlgorithm.calculate)
      .reverse
      .foreach(r => sb.append("Total Distance: " + TotalDistanceForRouteAlgorithm.calculate(r) + "km\t" + r.name_ + "\n"))
    sb.append("\n" + algoFact.averageTotalDistancePlusAverageNoStages(list))
    sb.toString()
  }

}
