package com.nateprat.core.action

import com.nateprat.model.RouteMap
import com.nateprat.system.user.Menu

object QuitAction extends Action[Unit] {

  override def identifier(): String = "Q"

  override def desc(): String = String.format(descString, "Quit the application")

  override def act(map:RouteMap): Unit = {
    Menu.setStopping(true)
  }

}
