package com.nateprat

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.Route

object Application extends App {

  val dataFile = new File("data.txt")
  val csvReader = new FileReader

  val dataList = csvReader.readResource(dataFile.getAbsolutePath)

  val transformer = new DefaultTransformer

  val routeList = transformer.transform[String, Route](dataList, RouteExtractor.extract)

  var routeMap = new RouteMap().Object.create(routeList)

  val algorithmFactory = new AlgorithmFactory


  val report = new Report(routeMap)
  println(report.getReport())

  CustomRoute.createNewRoute(routeMap)

  val data = RouteMapToCsvTranslator.translate(routeMap)

  val writeToFile = new WriteToFile

  writeToFile.writeToFile(dataFile.getAbsolutePath, data.toString)

}
