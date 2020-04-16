package com.nateprat.model

class Route(name:String, stages:List[Stage] = List.empty[Stage]) {

  val name_ = name
  var stages_ = stages

  def setStages(stages:List[Stage]): Route = {
    this.stages_ = stages
    this
  }

  override def toString: String = {
    "Route: " + name + "\nStages: " + stages.foldLeft(""){(acc, stage) => acc + "\n" + stage.toString}
  }
}
