package com.nateprat.core.action

import com.nateprat.core.interactive.CustomRoute
import com.nateprat.model.RouteMap
import com.nateprat.system.user.Menu

object CreateRouteAction extends Action[Unit] {

  override def act(map:RouteMap): Unit = {
    CustomRoute.createNewRoute(map)
  }

  override def identifier(): String = "C"

  override def desc(): String = String.format(descString, "Create/Modify Route")
}
