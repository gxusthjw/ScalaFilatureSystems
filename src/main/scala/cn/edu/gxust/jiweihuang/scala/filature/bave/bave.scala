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
    override def value(x: Double, parameters: Double*): Double = ???

    override def gradient(x: Double, parameters: Double*): Array[Double] = ???
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
