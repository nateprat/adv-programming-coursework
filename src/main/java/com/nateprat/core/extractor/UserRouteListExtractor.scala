package com.nateprat.core.extractor

import com.nateprat.core.extractor.StageExtractor.trySafeExtraction
import com.nateprat.core.interactive.UserRouteList

import scala.util.{Failure, Success, Try}

object UserRouteListExtractor extends Extractor[UserRouteList] {

  private def trySafeExtraction(line:String): Try[Array[String]] = {
    Try({
      line.split(":")
    })
  }

  override def extract(obj: Any): UserRouteList = {
    val str = obj.toString
    val split = str.split(",")
    val name = split(0).replace("List-", "")
    val rList = new UserRouteList(name)
    split.filter(str => !str.contains("List-")).foreach(obj => trySafeExtraction(obj) match {
      case Success(value) => rList.addRoute(value(0), value(1))
      case Failure(exception) => println("Failed due to the following reason:\n" + exception)
    })
    rList
  }

}
