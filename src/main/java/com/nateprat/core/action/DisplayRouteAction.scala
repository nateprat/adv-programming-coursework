package com.nateprat.core.action

import com.nateprat.core.map.RouteMapToRouteList
import com.nateprat.model.RouteMap
import com.nateprat.system.prompts.AppStrings
import com.nateprat.system.user.Menu
import com.nateprat.utils.UserInput

import scala.util.{Failure, Success, Try}

object DisplayRouteAction extends Action[Unit] {
  override def identifier(): String = "R"

  override def desc(): String = String.format(descString, "Display Route Information")

  override def act(map:RouteMap): Unit = {
    val rList = RouteMapToRouteList.map(map)
    var id = 0
    rList.foreach(r => {
      id += 1
      println(id + ")\t" + r.name_)
    })
    trySafeInput() match {
      case Success(value) => println(rList(value - 1).toString)
      case Failure(exception) => trySafeInput()
    }
  }

  def trySafeInput():Try[Int] = {
    Try({
      UserInput.userInputWithPrompt(AppStrings.enterRouteId).toInt
    })
  }

}
