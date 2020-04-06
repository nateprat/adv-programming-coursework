package com.nateprat.core.extractor

import org.scalatest.funsuite.AnyFunSuite

class StageExtractorTest extends AnyFunSuite {

  val underTest = StageExtractor

  test("extractTest") {
    val stageString = "1:City Chambers:0.75f"
    val stage = underTest.extract(stageString)
    assert(stage.id_ == 1)
    assert(stage.endPoint_.equals("City Chambers") )
    assert(stage.distanceKm_ == 0.75f)
  }

  test("extractFailureTest") {
    val stageString = "1:City Chambers0.75f"
    val stage = underTest.extract(stageString)
    assert(stage == null)
  }

}
