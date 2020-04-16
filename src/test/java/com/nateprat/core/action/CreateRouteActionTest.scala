package com.nateprat.core.action

import org.scalatest.funsuite.AnyFunSuite

class CreateRouteActionTest extends AnyFunSuite {

  val underTest = CreateRouteAction

  test("identifierTest") {
    assert("C".equals(underTest.identifier()))
  }

  test("descTest") {
    assert("Create/Modify Route (C)".equals(underTest.desc()))
  }

}
