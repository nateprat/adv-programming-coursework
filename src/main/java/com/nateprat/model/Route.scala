package com.nateprat.model

class Route(name:String, stages:List[Stage]) {

  val name_ = name
  val stages_ = stages

  override def toString: String = {
    "Route: " + name + "\nStages: " + stages.toString()
  }
}
