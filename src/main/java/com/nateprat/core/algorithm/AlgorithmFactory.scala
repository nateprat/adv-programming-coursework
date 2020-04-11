package com.nateprat.core.algorithm

import com.nateprat.model.{Route, RouteMap}

object AlgorithmFactory {

  def totalDistanceAndNoStagesForRoute(route: Route): String = {
    val noStages = route.stages_.size
    val totalDistance = TotalDistanceForRouteAlgorithm.calculate(route)
    route.name_ + " has " + noStages + " stages and a total distance of " + totalDistance + "km"
  }

  def averageTotalDistancePlusAverageNoStages(routes:List[Route]): String = {
    val avgStages = AverageNumberStagesAlgorithm.calculate(routes)
    val avgDistance = AverageTotalDistanceAlgorithm.calculate(routes)
    "Average No. of Stages per Route is " + avgStages + " and their average total distance is " + avgDistance + "km"
  }

}
