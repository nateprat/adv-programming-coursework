package com.nateprat.utils

object UserInput {

  def userInput(): String = {
    scala.io.StdIn.readLine()
  }

  def userInputWithPrompt(prompt:String): String = {
    scala.io.StdIn.readLine(prompt + "\n")
  }

}
