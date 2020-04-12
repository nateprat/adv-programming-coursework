package com.nateprat.core.data

import java.io.{BufferedWriter, File, FileWriter}
import java.nio.file.Files

import com.nateprat.core.pattern.Control
import com.nateprat.model.Route

object WriteToFile {

    def write(path:String, text:String): Unit = {
      val file = new File(path)
      file.createNewFile()
      Control.using(new BufferedWriter(new FileWriter(file))) {
        fw => {
          fw.write(text)
        }
      }
    }

}
