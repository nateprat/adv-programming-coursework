package com.nateprat.core.map

import com.nateprat.model.Stage

import scala.collection.mutable.ListBuffer

object ToListStageMapper extends Mapper[List[(Int, String, Float)], List[Stage]] {

  override def map(data: List[(Int, String, Float)]): List[Stage] = {
    data.foldLeft(ListBuffer.empty[Stage]){ (acc, l) => acc += new Stage(l._1, l._2, l._3)}.toList
  }

}
