package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

class ParabolaModel(val parabolaAlpha: Double, val parabolaBeta: Double) {
  def sizesValue(initialSize: Double, terminalSize: Double, length: Int): Array[Double] = {
    val make_array = new Array[Double](length)
    make_array(0) = initialSize
    for (i <- 1 until length) {
      make_array(i) = make_array(i - 1) + parabolaBeta - (i - 1) * parabolaAlpha
    }
    make_array
  }

  def sizesValueWithError(initialSize: Double, terminalSize: Double,
                          length: Int, error: Array[Double]): Array[Double] = {
    val make_array = new Array[Double](length)
    val values = sizesValue(initialSize, terminalSize, length)
    for (i <- 0 until length) {
      make_array(i) = values(i) + error(i)
    }
    make_array
  }

  def sizes(initialSize: Double, terminalSize: Double, length: Int, id: Int = 0): Sizes = {
    new Sizes(id, sizesValue(initialSize, terminalSize, length).toList)
  }

  def getSizesWithError(initialSize: Double, terminalSize: Double,
                        length: Int, error: Array[Double], id: Int = 0): Sizes = {
    new Sizes(id, sizesValueWithError(initialSize, terminalSize, length, error).toList)
  }
}

object ParabolaModel {
  def parabolaAlpha(sizes: Sizes): Double =
    (12 * sizes.average - 6 * sizes.initial - 6 * sizes.terminal) / ((sizes.length - 1) * (sizes.length - 2))

  def parabolaBeta(sizes: Sizes): Double =
    (6 * sizes.average - 4 * sizes.initial - 2 * sizes.terminal) / (sizes.length - 1)
}
