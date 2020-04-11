package com.nateprat.core.map

import com.nateprat.model.{Route, RouteMap}

import scala.collection.mutable.ListBuffer

object RouteMapToRouteList extends Mapper[RouteMap, List[Route]]{

  override def map(data: RouteMap): List[Route] = {
    val routes = ListBuffer.empty[Route]
    data.foreachEntry((key, obj) => routes.addOne(new Route(key, obj)))
    routes.toList
  }

}
