package com.nateprat.system.user

import java.io.File
import java.util.StringJoiner

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.{AppStrings, UserPrompt}
import com.nateprat.utils.UserInput

import scala.util.{Failure, Success, Try}

object Menu {

  var routeMap = new RouteMap
  private val stopping = false
  private var actions = List(CreateRouteAction, RouteDescAction)

 def mainMenu(): Unit = {
   println(AppStrings.welcome)
   routeMap = readFromFile()
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
    }).act()
  }

  private def createNewRoute(): Unit = {

  }

  private def readFromFile(): RouteMap = {
    UserPrompt.loading(5)
    val readFile = UserInput.userInputWithPrompt(AppStrings.readFromFile)
    if (!readFile.equalsIgnoreCase("y")) return new RouteMap
    val dataFile = getFilePath()
    val csvReader = new FileReader
    val dataList = csvReader.readFile(dataFile.getPath)
    val transformer = new DefaultTransformer
    val routeList = transformer.transform[String, Route](dataList, RouteExtractor.extract)
    new RouteMap().Object.create(routeList)
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
