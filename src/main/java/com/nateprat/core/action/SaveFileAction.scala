package com.nateprat.core.action

import com.nateprat.core.data.{RouteMapToCsvTranslator, WriteToFile}
import com.nateprat.system.prompts.AppStrings
import com.nateprat.system.user.Menu
import com.nateprat.utils.UserInput

object SaveFileAction extends Action[Unit] {
  override def identifier(): String = "S"

  override def desc(): String = String.format(descString, "Save Routes to File")

  override def act(): Unit = {
    val path = UserInput.userInputWithPrompt(AppStrings.saveDataPath)
    val data = RouteMapToCsvTranslator.translate(Menu.routeMap)
    WriteToFile.write(path, data)
  }

}
