package com.nateprat.model

import org.scalatest.funsuite.AnyFunSuite

class StageTest extends AnyFunSuite {

  test("getId") {
    var underTest = new Stage(1, "test", 0.0f)
    assert(underTest.id_.equals(1))
    underTest = new Stage(2, "test", 0.0f)
    assert(underTest.id_.equals(2))
  }

  test("getEndPoint") {
    var underTest = new Stage(1, "test", 0.0f)
    assert(underTest.endPoint_.equals("test"))
    underTest = new Stage(2, "test2", 0.0f)
    assert(underTest.endPoint_.equals("test2"))
  }

  test("getDistanceKm") {
    var underTest = new Stage(1, "test", 0.0f)
    assert(underTest.distanceKm_.equals(0.0f))
    underTest = new Stage(2, "test", 0.5f)
    assert(underTest.distanceKm_.equals(0.5f))
  }

  test("toStringTest") {
    var underTest = new Stage(1, "test", 0.0f)
    assert(underTest.toString.equals("Stage[id:1; endPoint:test; distance(Km):0.0]"))
  }


}
