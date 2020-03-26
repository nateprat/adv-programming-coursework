package com.nateprat.core.extractor

import org.scalatest.funsuite.AnyFunSuite

class RouteExtractorTest extends AnyFunSuite {

  val underTest = new RouteExtractor

  test("extractTest") {
    val data = "Education Route (GCU),1:University Of Strathclyde:0.65f"
    val route = underTest.extract(data)
    assert(route.name_.equals("Education Route (GCU)"))
    val stage1 = route.stages_(0)
    assert(stage1.id_ == 1)
    assert(stage1.endPoint_.equals("University Of Strathclyde"))
    assert(stage1.distanceKm_ == 0.65f)
  }

}
