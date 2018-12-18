package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

class StepwiseRegrModel(val coef: Array[Double]) {
  val k: Int = coef.length

  def differInitial(average: Double, slope: Double,
                    length: Int, initial: Double): Double = initial - (average - (slope * (length - 1)) / 2.0)

  def differ(average: Double, slope: Double,
             length: Int, initial: Double): Array[Double] = {
    val make_array: Array[Double] = new Array[Double](length)
    make_array(0) = differInitial(average, slope, length, initial)
    for (i <- 1 until length) {
      if (i <= k) {
        var make_sum_a: Double = 0.0
        for (r <- 1 to i) make_sum_a = make_sum_a + coef(r - 1) * make_array(i - r)
        make_array(i) = make_sum_a
      } else {
        var make_sum_b: Double = 0.0
        for (r <- 1 to k) make_sum_b = make_sum_b + coef(r - 1) * make_array(i - r)
        make_array(i) = make_sum_b
      }
    }
    make_array
  }

  /** The regression straight line */
  def line(average: Double, slope: Double,
           length: Int, initial: Double): List[Double] = {
    val make_array = new Array[Double](length)
    for (i <- 0 until length) {
      make_array(i) = average + slope * (i - (length - 1) / 2.0)
    }
    make_array.toList
  }

  def getSizes(id: Int, average: Double, slope: Double,
               length: Int, initial: Double): Sizes = {
    val make_array = new Array[Double](length)
    val make_differ = differ(average, slope, length, initial)
    val make_line = line(average, slope, length, initial)
    for (i <- 0 until length) make_array(i) = make_differ(i) + make_line(i)
    Sizes(id, make_array)
  }

  def differWithErr(average: Double, slope: Double,
                    length: Int, initial: Double)(err: Array[Double]): Array[Double] = {
    val make_array = new Array[Double](length)
    val make_differ = differ(average, slope, length, initial)
    for (i <- 0 until length) make_array(i) = make_differ(i) + err(i)
    make_array
  }


}

object StepwiseRegrModel {

}

class Stepwise {

}

object Stepwise {

}