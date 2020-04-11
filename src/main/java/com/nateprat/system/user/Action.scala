package com.nateprat.system.user

import com.nateprat.model.RouteMap

trait Action {
  protected val descString = "%s (" + identifier() + ")"
  def identifier():String
  def act()
  def desc():String
}
