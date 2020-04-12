package com.nateprat.core.action

trait Action[A] {
  protected val descString = "%s (" + identifier() + ")"
  def identifier():String
  def desc():String
  def act(): A
}
