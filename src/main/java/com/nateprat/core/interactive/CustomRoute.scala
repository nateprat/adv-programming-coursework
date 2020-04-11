package com.nateprat.core.interactive

import com.nateprat.model.{Route, RouteMap, Stage}
import com.nateprat.system.prompts.AppStrings
import com.nateprat.utils.UserInput

import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

object CustomRoute {

  def createNewRoute(map:RouteMap): Unit = {
    val routeName = UserInput.userInputWithPrompt(AppStrings.inputRouteName)
    val stages = map.getOrElseUpdate(routeName, List.empty[Stage])
    map.update(routeName, getStages(stages))
  }

  private def getSafeStageExtraction(): Try[Float] = {
    Try({
      val number = UserInput.userInputWithPrompt(AppStrings.inputStageDistance)
      number.toFloat
    })
  }

  private def getStages(sList:List[Stage]): List[Stage] = {
    val stageBuffer = sList.to(ListBuffer)
    var finished = false
    var id = 0
    if (stageBuffer.nonEmpty) {
      id = stageBuffer.last.id_
    }
    while (!finished) {
      id += 1
      val stageName = UserInput.userInputWithPrompt(AppStrings.inputStageName)
      if (!stageName.equalsIgnoreCase("q")) {
        getSafeStageExtraction() match {
          case Success(value) => stageBuffer.addOne(new Stage(id, stageName, value))
          case Failure(exception) => getSafeStageExtraction()
        }
      } else {
        finished = true
      }
    }
    stageBuffer.toList
  }


}
