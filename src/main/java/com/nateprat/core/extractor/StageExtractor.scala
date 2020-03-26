package com.nateprat.core.extractor

import com.nateprat.model.Stage

import scala.util.{Failure, Success, Try}


class StageExtractor extends Extractor[Stage]{

  private def trySafeExtraction(line:String): Try[Stage] = {
    Try({
      val splitRoute = line.split(":")
      val id = splitRoute(0).toInt
      val name = splitRoute(1)
      val distance = splitRoute(2).toFloat
      new Stage(id, name, distance)
    })
  }

  override def extract(obj: Any): Stage = {
    trySafeExtraction(obj.toString) match {
      case Success(value) => value
      case Failure(exception) =>
        println("Failed due to the following reason:\n" + exception)
        null
    }

  }
}
