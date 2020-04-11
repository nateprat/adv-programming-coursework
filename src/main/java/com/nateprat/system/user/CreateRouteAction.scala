package com.nateprat.system.user

import com.nateprat.core.interactive.CustomRoute

object CreateRouteAction extends Action {

  override def act(): Unit = {
    CustomRoute.createNewRoute(Menu.routeMap)
  }

  override def identifier(): String = "C"

  override def desc(): String = String.format(descString, "Create/Modify Route")
}
