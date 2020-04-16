package com.nateprat.core.data

import com.nateprat.model.Stage
import org.scalatest.funsuite.AnyFunSuite

class StageToCsvTranslatorTest extends AnyFunSuite {

  private val underTest = StageToCsvTranslator

  test("translateTest") {
    val stage = new Stage(1, "stage1", 1f)
    val result = underTest.translate(stage)
    val expected = "1:stage1:1.0f"
    assert(expected.equals(result))
  }

}
