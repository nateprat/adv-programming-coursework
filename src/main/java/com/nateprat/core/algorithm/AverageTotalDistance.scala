package com.nateprat.core.algorithm

import com.nateprat.model.Route

import scala.math.BigDecimal.RoundingMode

object AverageTotalDistance extends Algorithm[List[Route], Float] {
  override def calculate(obj: List[Route]): Float = {
    (BigDecimal.apply(obj.flatMap(x => x.stages_).map(b => b.distanceKm_).sum) / obj.size).setScale(2, RoundingMode.HALF_UP).floatValue
  }
}
