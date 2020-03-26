package com.nateprat.core.transformer

class DefaultTransformer {

  def transform[A,B](list:List[A], f: A => B): List[B] = {
    list.map(l => f(l))
  }

}
