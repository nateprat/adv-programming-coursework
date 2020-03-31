package com.nateprat.core.algorithm

import com.nateprat.model.Route

import scala.math.BigDecimal.RoundingMode

object TotalDistanceForRouteAlgorithm extends Algorithm[Route, Float] {
  override def calculate(obj: Route): Float = BigDecimal.apply(obj.stages_.map(x => x.distanceKm_).sum).setScale(2, RoundingMode.HALF_UP).floatValue
}
