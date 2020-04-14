package com.nateprat.core.map

import com.nateprat.model.{Route, RouteMap}

import scala.collection.mutable.ListBuffer

object RouteMapToRouteList extends Mapper[RouteMap, List[Route]]{

  override def map(data: RouteMap): List[Route] = {
    data.foldLeft(ListBuffer.empty[Route]){(acc, l) => acc.addOne(new Route(l._1, ToListStageMapper.map(l._2)))}.toList
  }

}
