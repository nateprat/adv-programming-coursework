package com.nateprat

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.Route

object Application extends App {

  val csvReader = new FileReader

  val dataList = csvReader.readResource("data.txt")

  val transformer = new DefaultTransformer

  val routeExtractor = new RouteExtractor

  val routeList = transformer.transform[String, Route](dataList, routeExtractor.extract)

  println(routeList)

}
