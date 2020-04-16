package com.nateprat.core.algorithm

import com.nateprat.model.{Route, Stage}
import org.scalatest.funsuite.AnyFunSuite

class AverageNumberStagesAlgorithmTest extends AnyFunSuite {

  private val underTest = AverageNumberStagesAlgorithm

  test("calculateTest") {
    val stages1 = new Stage(1, "stage11", 1f)::new Stage(2, "stage12", 2f)::new Stage(3, "stage13", 3f)::Nil
    val route1 = new Route("RouteName1", stages1)
    val stages2 = new Stage(1, "stage21", 21f)::Nil
    val route2 = new Route("RouteName2", stages2)
    val rList = route1::route2::Nil
    val result = underTest.calculate(rList)
    assert(2 == result)
  }

}
