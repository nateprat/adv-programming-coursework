package com.nateprat.core.algorithm

import com.nateprat.model.{Route, Stage}
import org.scalatest.funsuite.AnyFunSuite

class TotalDistanceForRouteAlgorithmTest extends AnyFunSuite {

  private val underTest = TotalDistanceForRouteAlgorithm

  test("calculateTest") {
    val stages1 = new Stage(1, "stage11", 1f)::new Stage(2, "stage12", 2f)::new Stage(3, "stage13", 3f)::Nil
    val route1 = new Route("RouteName1", stages1)
    val result = underTest.calculate(route1)
    assert(6 == result)
  }

}
