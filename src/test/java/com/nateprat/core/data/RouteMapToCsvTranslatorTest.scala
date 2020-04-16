package com.nateprat.core.data

import com.nateprat.model.RouteMap
import org.scalatest.funsuite.AnyFunSuite

class RouteMapToCsvTranslatorTest extends AnyFunSuite {

  private val underTest = RouteMapToCsvTranslator

  test("translateTest") {
    val rMap = new RouteMap()
    rMap.addOne("Route", (1, "stage1", 1f)::Nil)
    val result = underTest.translate(rMap)
    val expected = "Route,1:stage1:1.0f"
    assert(expected.equals(result))
  }

}
