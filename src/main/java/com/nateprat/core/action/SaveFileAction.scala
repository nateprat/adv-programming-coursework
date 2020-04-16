package com.nateprat.core.action

import com.nateprat.core.data.{RouteMapToCsvTranslator, UserRouteListToCsvTranslator, WriteToFile}
import com.nateprat.model.RouteMap
import com.nateprat.system.prompts.AppStrings
import com.nateprat.system.user.Menu
import com.nateprat.utils.UserInput

object SaveFileAction extends Action[Unit] {
  override def identifier(): String = "S"

  override def desc(): String = String.format(descString, "Save Routes to File")

  override def act(map:RouteMap): Unit = {
    val path = UserInput.userInputWithPrompt(AppStrings.saveDataPath)
    val data = RouteMapToCsvTranslator.translate(map) + "\n" + UserRouteListToCsvTranslator.translate(Menu.userLists.toList)
    WriteToFile.write(path, data)
  }

}
