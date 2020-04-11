package com.nateprat.system.user

object BlankAction extends Action {
  override def identifier(): String = "WOW"

  override def act(): Unit = {}

  override def desc(): String = "BLANK ACTION, THIS SHOULD NOT OCCUR"
}
