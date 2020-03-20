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

}
