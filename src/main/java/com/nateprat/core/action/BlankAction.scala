package com.nateprat.core.action

object BlankAction extends Action[Unit] {
  override def identifier(): String = "WOW"

  override def act(): Unit = {}

  override def desc(): String = "BLANK ACTION, THIS SHOULD NOT OCCUR"
}
