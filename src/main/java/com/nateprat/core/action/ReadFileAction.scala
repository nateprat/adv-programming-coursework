package com.nateprat.core.action

import java.io.File

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Route, RouteMap}
import com.nateprat.system.prompts.{AppStrings, UserPrompt}
import com.nateprat.utils.UserInput

object ReadFileAction extends Action[RouteMap] {
  override def identifier(): String = "R"

  override def desc(): String = String.format(descString, "Read File")

  override def act(): RouteMap = {
    UserPrompt.loading(5)
    val readFile = UserInput.userInputWithPrompt(AppStrings.readFromFile)
    if (!readFile.equalsIgnoreCase("y")) return new RouteMap
    val dataFile = getFilePath()
    val dataList = FileReader.readFile(dataFile.getPath)
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
