package com.nateprat.core.action

import com.nateprat.model.RouteMap

trait Action[A] {
  protected val descString = "%s (" + identifier() + ")"
  def identifier():String
  def desc():String
  def act(map:RouteMap): A
}
