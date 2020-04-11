package com.nateprat

import java.io.File
import java.util.StringJoiner

import com.nateprat.core.algorithm.AlgorithmFactory
import com.nateprat.core.data.{FileReader, RouteMapToCsvTranslator, WriteToFile}
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.interactive.CustomRoute
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Report, Route, RouteMap}
import com.nateprat.system.user.Menu


object Application extends App {



  Menu.mainMenu()

//  val dataFile = new File("data.txt")
//  val csvReader = new FileReader
//  val dataList = csvReader.readResource(dataFile.getAbsolutePath)
//  val transformer = new DefaultTransformer
//  val routeList = transformer.transform[String, Route](dataList, RouteExtractor.extract)
//  var routeMap = new RouteMap().Object.create(routeList)
//
//  val report = new Report(routeMap)
//  println(report.getReport())
//
//  CustomRoute.createNewRoute(routeMap)
//
//  val data = RouteMapToCsvTranslator.translate(routeMap)
//
//  val writeToFile = new WriteToFile
//
//  writeToFile.writeToFile(dataFile.getAbsolutePath, data.toString)

}
