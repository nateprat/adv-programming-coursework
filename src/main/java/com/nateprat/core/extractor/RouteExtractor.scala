package com.nateprat.core.extractor

import com.nateprat.model.{Route, Stage}

import scala.util.{Failure, Success, Try}

object RouteExtractor extends Extractor[Route] {

  override def extract(obj: Any): Route = {
    trySafeExtraction(obj.toString) match {
      case Success(value) => value
      case Failure(exception) =>
        println("Failed due to the following reason:\n" + exception)
        null
    }
  }

  private def trySafeExtraction(line:String): Try[Route] = {
    Try({
      val splitRouteBuffer = line.split(",").toBuffer
      val title = splitRouteBuffer(0)
      splitRouteBuffer.remove(0)
      val stages = extractStages(splitRouteBuffer.toArray)
      new Route(title, stages)
    })
  }

  private def extractStages(array:Array[String]): List[Stage] = {
    array.map(StageExtractor.extract).toList
  }
}
