package com.nateprat.system.user

import java.io.File
import java.util.StringJoiner

import com.nateprat.core.action.{AverageTotalDistanceAndStagesAction, BlankAction, CreateRouteAction, CreateUserListAction, DisplayRouteAction, DisplayUserListAction, QuitAction, ReadFileAction, RouteDescAction, SaveFileAction}
import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.interactive.UserRouteList
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.{AppStrings, UserPrompt}
import com.nateprat.utils.UserInput

import scala.collection.mutable.ListBuffer


object Menu {

  private var routeMap = new RouteMap
  var userLists = ListBuffer.empty[UserRouteList]
  private var stopping = false
  private val actions = List(CreateRouteAction, RouteDescAction, AverageTotalDistanceAndStagesAction, DisplayRouteAction, CreateUserListAction, DisplayUserListAction, SaveFileAction, QuitAction)

 def mainMenu(): Unit = {
   println(AppStrings.welcome)
   routeMap = ReadFileAction.act(routeMap)
   do {
      userAction()
   } while (!stopping)
   UserPrompt.loading(5)
   println(AppStrings.thanksForUsingApp)
 }

  private def userAction(): Unit = {
    val prompt = new StringJoiner(", ", "\nPress the corresponding key...\n", "")
    actions.foreach(action => prompt.add(action.desc()))
    val input = UserInput.userInputWithPrompt(prompt.toString)
    actions.find(act => act.identifier().equalsIgnoreCase(input)).getOrElse({
      println("action not found")
      UserPrompt.loading()
      BlankAction
    }).act(routeMap)
  }

  def setStopping(stopping:Boolean): Unit = {
    this.stopping = stopping
  }
}
