package com.nateprat.core.map

import com.nateprat.model.Stage

import scala.collection.mutable.ListBuffer

object ToListTypeFromStageMapper extends Mapper[List[Stage], List[(Int, String, Float)]]{

  override def map(data: List[Stage]): List[(Int, String, Float)] = {
    data.foldLeft(ListBuffer.empty[(Int, String, Float)]){(acc, l) => acc.addOne(l.id_, l.endPoint_, l.distanceKm_)}.toList
  }

}
