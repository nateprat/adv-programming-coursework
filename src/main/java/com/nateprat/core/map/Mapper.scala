package com.nateprat.core.map

trait Mapper[A, B] {
  def map(data:A): B
}
