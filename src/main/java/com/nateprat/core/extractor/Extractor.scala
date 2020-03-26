package com.nateprat.core.extractor

trait Extractor[A] {
  def extract(obj:Any): A
}
