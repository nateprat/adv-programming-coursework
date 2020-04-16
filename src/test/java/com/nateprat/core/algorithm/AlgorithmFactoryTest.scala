package com.nateprat.core.algorithm

import com.nateprat.model.{Route, Stage}
import org.scalatest.funsuite.AnyFunSuite

class AlgorithmFactoryTest extends AnyFunSuite {

  private var underTest = AlgorithmFactory

  test("totalDistanceAndNoStagesForRouteTest") {
    val stages = new Stage(1, "stage1", 1f)::new Stage(2, "stage2", 2f)::new Stage(3, "stage3", 3f)::Nil
    val route = new Route("RouteName", stages)
    val expected = "RouteName has 3 stages and a total distance of 6.0km"
    val str = underTest.totalDistanceAndNoStagesForRoute(route)
    assert(expected.equals(str))
  }

  test("averageTotalDistancePlusAverageNoStagesTest") {
    val stages1 = new Stage(1, "stage11", 1f)::new Stage(2, "stage12", 2f)::new Stage(3, "stage13", 3f)::Nil
    val route1 = new Route("RouteName1", stages1)
    val stages2 = new Stage(1, "stage21", 21f)::Nil
    val route2 = new Route("RouteName2", stages2)
    val rList = route1::route2::Nil
    val expected = "Average No. of Stages per Route is 2 and their average total distance is 13.5km"
    val str = underTest.averageTotalDistancePlusAverageNoStages(rList)
    assert(expected.equals(str))
  }

}
