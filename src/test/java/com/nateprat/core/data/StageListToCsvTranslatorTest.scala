package com.nateprat.core.data

import org.scalatest.funsuite.AnyFunSuite

class StageListToCsvTranslatorTest extends AnyFunSuite {

  private val underTest = StageListToCsvTranslator

  test("translateTest") {
    val result = underTest.translate((1, "stage1", 1f))
    val expected = "1:stage1:1.0f"
    assert(expected.equals(result))
  }

}
