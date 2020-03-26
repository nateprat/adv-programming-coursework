package com.nateprat

import com.nateprat.core.data.FileReader
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Route, Stage}

import scala.collection.mutable.ListBuffer

object Application extends App {

  val csvReader = new FileReader

  val dataList = csvReader.readResource("data.txt")

  val rawDataTransformer = new DefaultTransformer


  val transformer = new DefaultTransformer
  val routeExtractor = new RouteExtractor

  val routeList = rawDataTransformer.transform[String, Route](dataList, routeExtractor.extract)

  println(routeList)

}
