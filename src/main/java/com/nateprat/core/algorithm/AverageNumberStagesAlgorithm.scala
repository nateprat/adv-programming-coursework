package com.nateprat.core.algorithm

import com.nateprat.model.Route

import scala.math.BigDecimal.RoundingMode

object AverageNumberStagesAlgorithm extends Algorithm[List[Route], Int]{
  override def calculate(obj: List[Route]): Int = BigDecimal.apply(obj.map(x => x.stages_).map(b => b.size).sum / obj.size).setScale(1, RoundingMode.HALF_UP).intValue
}
