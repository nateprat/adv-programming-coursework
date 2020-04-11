package com.nateprat.core.data

trait Translator[A, B] {
  def translate(data:A): B
}
