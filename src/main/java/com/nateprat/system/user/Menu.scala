package com.nateprat.system.user

import java.io.File
import java.util.StringJoiner

import com.nateprat.core.action.{AverageTotalDistanceAndStagesAction, BlankAction, CreateRouteAction, DisplayRouteAction, QuitAction, ReadFileAction, RouteDescAction, SaveFileAction}
import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.{AppStrings, UserPrompt}
import com.nateprat.utils.UserInput


object Menu {

  var routeMap = new RouteMap
  private val stopping = false
  private val actions = List(CreateRouteAction, RouteDescAction, AverageTotalDistanceAndStagesAction, DisplayRouteAction, SaveFileAction, QuitAction)

 def mainMenu(): Unit = {
   println(AppStrings.welcome)
   routeMap = ReadFileAction.act(routeMap)
   do {
      userAction()
   } while (!stopping)
 }

  def setup(): Unit = {

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

  private def createNewRoute(): Unit = {

  }

  private def getFilePath(): File = {
    val dataFilePath = UserInput.userInputWithPrompt(AppStrings.inputDataFile)
    val file = new File(dataFilePath)
    if (!file.exists()) {
      println(AppStrings.fileDoesNotExist)
      getFilePath()
    }
    file
  }
}
