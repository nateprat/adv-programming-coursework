package com.nateprat.core.data

import java.util.StringJoiner

import com.nateprat.model.{Route, RouteMap}

object RouteMapToCsvTranslator extends Translator[RouteMap, String] {

  override def translate(data: RouteMap): String = {
    val string = new StringJoiner("\n")
    data.foreachEntry((key, obj) => {
      val route = new StringJoiner(",")
      route.add(key)
      obj.foreach(stage => route.add(StageToCsvTranslator.translate(stage)))
      string.add(route.toString)
    })
    string.toString
  }

}
