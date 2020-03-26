package com.nateprat.model

import org.scalatest.funsuite.AnyFunSuite

class RouteTest extends AnyFunSuite {

  test("getName") {
    var underTest = new Route("test", new Stage(1, "stage", 0.5f)::new Stage(2, "stage2", 1.0f)::Nil)
    assert(underTest.name_.equals("test"))
  }

  test("getStages") {
    val stages = new Stage(1, "stage", 0.5f)::new Stage(2, "stage2", 1.0f)::Nil
    val underTest = new Route("test", stages)
    assert(underTest.stages_.equals(stages))
  }

  test("toStringTest") {
    val stages = new Stage(1, "stage", 0.5f)::new Stage(2, "stage2", 1.0f)::Nil
    val underTest = new Route("test", stages)
    assert(underTest.toString.equals("Route: test\nStages: List(Stage[id:1; endPoint:stage; distance(Km):0.5], Stage[id:2; endPoint:stage2; distance(Km):1.0])"))
  }

}
