package com.nateprat.core.data

import java.util.StringJoiner

import com.nateprat.core.interactive.UserRouteList
import com.nateprat.model.RouteMap

object UserRouteListToCsvTranslator extends Translator[List[UserRouteList], String] {

  override def translate(data: List[UserRouteList]): String = {
    val sj = new StringJoiner("\n")
    data.foreach(url => sj.add(url.toString))
    sj.toString
  }

}
