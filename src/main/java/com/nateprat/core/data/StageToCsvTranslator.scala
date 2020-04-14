package com.nateprat.core.data

import java.util.StringJoiner

import com.nateprat.model.Stage

object StageToCsvTranslator extends Translator[Stage, String] {

  override def translate(data: Stage): String = {
    val sj = new StringJoiner(":")
    sj.add(String.valueOf(data.id_))
    sj.add(data.endPoint_)
    sj.add(String.valueOf(data.distanceKm_) + "f")
    sj.toString
  }

}
