package com.nateprat.core.data

import com.nateprat.core.pattern.Control

import scala.io.Source

object FileReader {

  def readFile(filePath:String): List[String] = {
    Control.using(Source.fromFile(filePath)) {
      source => {
        source.getLines().toList
      }
    }
  }

  def readResource(filePath:String): List[String] = {
    Control.using(Source.fromResource(filePath)) {
      source => {
        source.getLines().toList
      }
    }
  }

}
