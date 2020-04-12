package com.nateprat.model

import com.nateprat.core.map.RouteMapToRouteList

import scala.collection.mutable

class RouteMap extends mutable.HashMap[String, List[Stage]] {

  object Object {
    def create(routes:List[Route]): RouteMap = {
      val routeMap = new RouteMap
      routes.foreach(route => routeMap.addOne(route.name_, route.stages_))
      routeMap
    }
  }

  override def toString = RouteMapToRouteList.map(this).toString()
}
