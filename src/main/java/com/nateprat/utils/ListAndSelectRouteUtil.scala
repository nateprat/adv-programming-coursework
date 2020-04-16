package com.nateprat.utils

import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.AppStrings

import scala.util.{Failure, Success, Try}

object ListAndSelectRouteUtil {

  def run(rList:List[Route]): Route = {
    var id = 0
    rList.foreach(r => {
      id += 1
      println(id + ")\t" + r.name_)
    })
    var selectedId = -1
    while (!(0 to rList.size contains(selectedId))) {
      selectedId = trySafeInput() match {
        case Success(value) => value - 1
        case Failure(exception) => -1
      }
    }
    rList(selectedId)
  }

  private def trySafeInput(): Try[Int] = {
    Try({
      UserInput.userInputWithPrompt(AppStrings.enterRouteId).toInt
    })
  }

}
