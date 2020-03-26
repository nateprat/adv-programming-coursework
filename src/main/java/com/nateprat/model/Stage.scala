package com.nateprat.model

class Stage(id:Int, endPoint:String, distanceKm:Float) {

  val id_ = id
  val endPoint_ = endPoint
  val distanceKm_ = distanceKm

  override def toString: String = {
    "Stage[id:" + id + "; endPoint:" + endPoint + "; distance(Km):" + distanceKm + "]"
  }
}
