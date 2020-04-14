package com.nateprat.core.data

import java.util.StringJoiner

object StageListToCsvTranslator extends Translator[(Int, String, Float), String]{

  override def translate(data: (Int, String, Float)): String = {
    val sj = new StringJoiner(":")
    sj.add(data._1.toString)
    sj.add(data._2)
    sj.add(data._3.toString)
    sj.toString
  }

}
