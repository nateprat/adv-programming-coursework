package com.nateprat.core.data

import java.util.StringJoiner

import com.nateprat.model.{Route, RouteMap}

object RouteMapToCsvTranslator extends Translator[RouteMap, String] {

  override def translate(data: RouteMap): String = {
    data.foldLeft(new StringJoiner("\n")){(acc, l) => {
      val route = new StringJoiner(",")
      route.add(l._1)
      l._2.sorted.foreach(stage => route.add(StageListToCsvTranslator.translate(stage)))
      acc.add(route.toString)
    }}.toString
  }

}
