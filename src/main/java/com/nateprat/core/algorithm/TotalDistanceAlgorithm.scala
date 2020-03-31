package com.nateprat.core.algorithm

import com.nateprat.model.Route

object TotalDistanceAlgorithm extends Algorithm[Route, Float] {
  override def calculate(obj: Route): Float = obj.stages_.map(x => x.distanceKm_).sum
}
