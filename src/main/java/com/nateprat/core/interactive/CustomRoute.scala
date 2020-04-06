package com.nateprat.core.interactive

import com.nateprat.model.{Route, Stage}
import com.nateprat.utils.UserInput

import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

object CustomRoute {

  def createNewRoute(): Route = {
    val routeName = UserInput.userInputWithPrompt("Enter route name...")
    def getStages(sList:ListBuffer[Stage]): List[Stage] = {
      var finished = false
      var id = 0
      while (!finished) {
        id += 1
        val stageName = UserInput.userInputWithPrompt("Enter stage name... (or press q to finish)")
        if (!stageName.equalsIgnoreCase("q")) {
          getSafeStageExtraction() match {
            case Success(value) => sList.addOne(new Stage(id, stageName, value))
            case Failure(exception) => getSafeStageExtraction()
          }
        } else {
          finished = true
        }
      }
      sList.toList
    }
    new Route(routeName, getStages(new ListBuffer[Stage]))
  }

  private def getSafeStageExtraction(): Try[Float] = {
    Try({
      val number = UserInput.userInputWithPrompt("Enter stage distance...")
      number.toFloat
    })
  }



}
