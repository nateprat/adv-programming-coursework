package com.nateprat.core.action

import java.io.File

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.{Extractor, RouteExtractor, UserRouteListExtractor}
import com.nateprat.core.interactive.UserRouteList
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.{AppStrings, UserPrompt}
import com.nateprat.system.user.Menu
import com.nateprat.utils.UserInput

import scala.collection.mutable.ListBuffer

object ReadFileAction extends Action[RouteMap] {

  val transformer = new DefaultTransformer

  override def identifier(): String = "R"

  override def desc(): String = String.format(descString, "Read File")

  override def act(map:RouteMap): RouteMap = {
    UserPrompt.loading(5)
    val readFile = UserInput.userInputWithPrompt(AppStrings.readFromFile)
    if (!readFile.equalsIgnoreCase("y")) return new RouteMap
    val dataFile = getFilePath()
    val dataList = FileReader.readFile(dataFile.getPath)
    getUserLists(dataList)
    new RouteMap().Object.create(getRouteLists(dataList))
  }

  private def getUserLists(dataList:List[String]): Unit = {
    val strList = dataList.to(LazyList)
      .filter(s => s.startsWith("List-"))
      .toList
    Menu.userLists.addAll(transformer.transform[String, UserRouteList](strList, UserRouteListExtractor.extract))
  }

  private def getRouteLists(dataList:List[String]): List[Route] = {
    val strList = dataList.to(LazyList)
      .filter(s => !s.startsWith("List-"))
      .toList
    transformer.transform[String, Route](strList, RouteExtractor.extract)
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
