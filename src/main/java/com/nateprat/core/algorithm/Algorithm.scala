package com.nateprat.core.algorithm

trait Algorithm[A, B] {
  def calculate(obj:A): B
}
