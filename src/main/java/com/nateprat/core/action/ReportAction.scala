package com.nateprat.core.action
import com.nateprat.model.{Report, RouteMap}

object ReportAction extends Action[Unit] {
  override def identifier(): String = "R"

  override def desc(): String = String.format(descString, "Get Route Report")

  override def act(map: RouteMap): Unit = {
    println(new Report(map).getReport())
  }
}
