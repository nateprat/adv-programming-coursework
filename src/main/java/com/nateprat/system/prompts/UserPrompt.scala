package com.nateprat.system.prompts

object UserPrompt {

  def loading(numDots:Int = 5, delay:Long = 300): Unit = {
    for (i <- 1 to numDots) {
      print(".")
      Thread.sleep(delay)
    }
    println()
  }



}
