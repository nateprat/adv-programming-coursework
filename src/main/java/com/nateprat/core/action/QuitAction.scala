package com.nateprat.core.action

import com.nateprat.system.prompts.{AppStrings, UserPrompt}

object QuitAction extends Action[Unit] {

  override def identifier(): String = "Q"

  override def desc(): String = String.format(descString, "Quit the application")

  override def act(): Unit = {
    UserPrompt.loading(5)
    println(AppStrings.thanksForUsingApp)
    System.exit(0)
  }

}
