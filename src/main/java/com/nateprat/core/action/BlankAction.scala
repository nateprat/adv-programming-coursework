package com.nateprat.core.action

import com.nateprat.model.RouteMap

object BlankAction extends Action[Unit] {
  override def identifier(): String = "WOW"

  override def act(map:RouteMap): Unit = {}

  override def desc(): String = "BLANK ACTION, THIS SHOULD NOT OCCUR"
}
