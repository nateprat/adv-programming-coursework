package com.nateprat.core.transformer

class DefaultTransformer extends Transformer {

  override def transform[A,B](list:List[A], f: A => B): List[B] = {
    super.transform(list, f)
  }

}
