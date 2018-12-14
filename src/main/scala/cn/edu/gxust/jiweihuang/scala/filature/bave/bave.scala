package cn.edu.gxust.jiweihuang.scala.filature.bave

import cn.edu.gxust.jiweihuang.scala.math.function.univariate.TQuadraticVertexLogistic
import org.hipparchus.analysis.ParametricUnivariateFunction

import math._

trait Bave {
  var baveLength: Double

  def baveSize(pos: Double): Double
}

trait TQVLBaveModel extends Bave with TQuadraticVertexLogistic {

  val modelBaveLength: Double = 1200
  val initialSize: Double = 3.5
  val terminalSize: Double = 1.8
  val maxSizePos: Double = 200

  override val quadraticVertexA: Double = (initialSize - terminalSize) * (1 + exp(logisticK * maxSizePos)) / pow(modelBaveLength, 2)
  override val quadraticVertexB: Double = modelBaveLength
  override val quadraticVertexC: Double = 0
  override val logisticM: Double = 1
  override val logisticK: Double = 4 / (modelBaveLength - maxSizePos)
  override val logisticX0: Double = maxSizePos
  override val quadraticVertexLogisticD: Double = terminalSize

  var lowerPos: Double = 0
  var upperPos: Double = modelBaveLength
  override var baveLength: Double = upperPos - lowerPos

  override def baveSize(pos: Double): Double = {
    value(pos)
  }

}

object TQVLBaveModel {

  class Parametric extends ParametricUnivariateFunction {
    override def value(x: Double, parameters: Double*): Double = {
      val L = parameters(0)
      val s = parameters(1)
      val t = parameters(2)
      val m = parameters(3)
      ((1 + exp(4 * m / (L - m))) * (s - t) * pow(x - L, 2) / ((1 + exp(-4 * (x - m) / (L - m))) * pow(L, 2))) + t
    }

    override def gradient(x: Double, parameters: Double*): Array[Double] = {
      val L = parameters(0)
      val s = parameters(1)
      val t = parameters(2)
      val m = parameters(3)
      val make_array: Array[Double] = new Array[Double](4)
      val tem1 = -2 * (1 + exp(4 * m / (L - m))) * (s - t) * (x - L) / (1 + exp(-4 * (x - m) / (L - m)))
      make_array(0) = {
        (tem1 / pow(L, 2)) + (tem1 / pow(L, 3)) +
          ((-4 * exp(4 * m / (L - m)) * m * (s - t) * pow(x - L, 2)) / ((1 + exp(-4 * (x - m) / (L - m))) * pow(L, 2) * pow(L - m, 2))) +
          (-4 * exp(-4 * (x - m) / (L - m)) * (1 + exp(4 * m / (L - m))) * (s - t) * pow(x - L, 2) * (x - m)) / (pow(1 + exp(-4 * (x - m) / (L - m)), 2) * pow(L, 2) * pow(L - m, 2))
      }
      make_array(1) = {
        (1 + exp(4 * m / (L - m))) * pow(L - x, 2) / (pow(L, 2) * (1 + exp(4 * (m - x) / (L - m))))
      }
      make_array(2) = {
        1 - make_array(1)
      }
      make_array(3) = {
        4 * exp(4 * (x + m) / (L - m)) * (s - t) * pow(x - L, 2) * ((exp(4 * x / (L - m)) - 1) * L + x + exp(4 * m / (L - m))) / (pow(L, 2) * pow(L - m, 2) * (exp(4 * m / (L - m)) + exp(4 * x / (L - m))))
      }
      return make_array
    }
  }



}

case class QVLBave(override val modelBaveLength: Double = 1200,
                   override val initialSize: Double = 3.5,
                   override val terminalSize: Double = 1.8,
                   override val maxSizePos: Double = 200)
  extends TQVLBaveModel

class QVLBaveV1(override val modelBaveLength: Double,
                override val initialSize: Double,
                val terminalInitialSizeRatio: Double,
                val maxLengthRatio: Double
               )
  extends TQVLBaveModel {
  override val terminalSize: Double = initialSize * terminalInitialSizeRatio
  override val maxSizePos: Double = modelBaveLength * maxLengthRatio
}

object QVLBaveV1 {

  class Parametric extends ParametricUnivariateFunction {
    override def value(x: Double, parameters: Double*): Double = ???

    override def gradient(x: Double, parameters: Double*): Array[Double] = ???
  }

}
