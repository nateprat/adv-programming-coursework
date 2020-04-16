package com.nateprat.core.action

import com.nateprat.model.RouteMap
import org.scalatest.funsuite.AnyFunSuite

class AverageTotalDistanceAndStagesActionTest extends AnyFunSuite {

  val underTest = AverageTotalDistanceAndStagesAction

  test("identifierTest") {
    assert("A".equals(underTest.identifier()))
  }

  test("descTest") {
    assert("Average Total Distance and Stages of Routes (A)".equals(underTest.desc()))
  }

}
