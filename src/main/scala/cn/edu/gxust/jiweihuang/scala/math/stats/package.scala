package cn.edu.gxust.jiweihuang.scala.math

import scala.math._

package object stats {

  def average[B <: Seq[Double]](x: B): Double = {
    var make_sum = 0.0
    for (xi <- x) make_sum = make_sum + xi
    make_sum / x.length
  }

  def vari[B <: Seq[Double]](x: B): Double = {
    var make_sum = 0.0
    val a = average(x)
    for (xi <- x) make_sum = make_sum + pow(xi - a, 2.0)
    make_sum / x.length
  }

  def std[B <: Seq[Double]](x: B): Double = sqrt(vari(x))

  def covari[B <: Seq[Double]](x: B, y: B): Double = {
    if (x.length != y.length) throw new IllegalArgumentException(
      s"Expected the length of parameter {x} is equals to which of parameter {y},but got {x.length = ${x.length}} and {y.length = ${y.length}}.")
    var make_sum = 0.0
    for (xi <- x; yi <- y) make_sum = make_sum + (xi - average(x)) * (yi - average(y))
    make_sum / x.length
  }

  def cor[B <: Seq[Double]](x: B, y: B): Double = covari(x, y) / (std(x) * std(y))
}
