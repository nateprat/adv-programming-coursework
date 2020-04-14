package com.nateprat.model

import com.nateprat.core.map.{RouteMapToRouteList, ToListTypeFromStageMapper}

import scala.collection.mutable

class RouteMap extends mutable.HashMap[String, List[(Int, String, Float)]] {

  object Object {
    def create(routes:List[Route]): RouteMap = {
      routes.foldLeft(new RouteMap){(acc, l) => acc.addOne(l.name_, ToListTypeFromStageMapper.map(l.stages_))}
    }
  }

  override def toString = RouteMapToRouteList.map(this).toString()
}
