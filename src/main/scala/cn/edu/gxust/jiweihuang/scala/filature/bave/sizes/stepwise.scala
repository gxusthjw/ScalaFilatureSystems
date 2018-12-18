package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

class StepwiseRegrModel(val average: Double, val slope: Double,
                        val length: Int, val initial: Double,
                        val errVari: Double, val coef: Array[Double]) {
  val k: Int = coef.length
  val differInitial: Double = initial - (average - (slope * (length - 1)) / 2.0)

  def differ: Array[Double] = {
    val make_array: Array[Double] = new Array[Double](length)
    make_array(0) = differInitial
    for (i <- 1 until length) {
      if (i <= k) {
        var make_sum_a:Double = 0.0
        for(r<-1 to i) make_sum_a = make_sum_a + coef(r-1) * make_array(i-r)
        make_array(i) =make_sum_a
      } else {
        var make_sum_b:Double = 0.0
        for(r<-1 to k) make_sum_b = make_sum_b + coef(r-1) * make_array(i-r)
        make_array(i) =make_sum_b
      }
    }
    make_array
  }

}

object StepwiseRegrModel {

}

class Stepwise {

}

object Stepwise {

}