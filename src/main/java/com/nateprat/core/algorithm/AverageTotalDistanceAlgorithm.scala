package com.nateprat.core.algorithm

import com.nateprat.model.Route

import scala.math.BigDecimal.RoundingMode

object AverageTotalDistanceAlgorithm extends Algorithm[List[Route], Float] {
  override def calculate(obj: List[Route]): Float = {
    (BigDecimal.apply(obj.foldLeft(0f){(acc, i) => acc + TotalDistanceForRouteAlgorithm.calculate(i)}) / obj.size).setScale(2, RoundingMode.HALF_UP).floatValue
  }
}
