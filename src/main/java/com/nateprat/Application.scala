package com.nateprat

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.Route

object Application extends App {

  val csvReader = new FileReader

  val dataList = csvReader.readResource("data.txt")

  val transformer = new DefaultTransformer

  val routeList = transformer.transform[String, Route](dataList, RouteExtractor.extract)

  var routeMap = new mutable.HashMap[String, List[Stage]]()

  routeList.foreach(r => routeMap.addOne(r.name_, r.stages_))

  println(routeMap)

  val algorithmFactory = new AlgorithmFactory

  println(algorithmFactory.averageTotalDistancePlusAverageNoStages(routeList))
  routeList.foreach(x => println(algorithmFactory.totalDistanceAndNoStagesForRoute(x)))

}
