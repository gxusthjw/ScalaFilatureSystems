package cn.edu.gxust.jiweihuang.scala.filature.bave

import cn.edu.gxust.jiweihuang.scala.math.function.univariate.TQuadraticVertexLogistic

trait Bave {
  val baveLength: Double

  def baveSize(pos: Double): Double
}

trait TQVLBaveModel extends Bave with TQuadraticVertexLogistic {

  val modelBaveLength: Double = 1200
  val initialSize: Double = 3.5
  val terminalSize: Double = 1.8
  val maxSizePos: Double = 200

  override val quadraticVertexA: Double = _
  override val quadraticVertexB: Double = _
  override val quadraticVertexC: Double = 0
  override val logisticM: Double = 1
  override val logisticK: Double = _
  override val logisticX0: Double = _
  override val quadraticVertexLogisticD: Double = _

  var lowerPos: Double = 0
  var upperPos: Double = modelBaveLength
  override val baveLength: Double = upperPos - lowerPos

  override def baveSize(pos: Double): Double = {
    value(pos)
  }
}

case class QVLBave(override val modelBaveLength: Double = 1200,
                   override val initialSize: Double = 3.5,
                   override val terminalSize: Double = 1.8,
                   override val maxSizePos: Double = 200)
  extends TQVLBaveModel

class QVLBaveV1() extends TQVLBaveModel {
  override val modelBaveLength: Double = _
  override val initialSize: Double = _
  override val terminalSize: Double = _
  override val maxSizePos: Double = _
}

class QVLBaveV2() extends TQVLBaveModel {
  override val modelBaveLength: Double = _
  override val initialSize: Double = _
  override val terminalSize: Double = _
  override val maxSizePos: Double = _
}

class QVLBaveV3() extends TQVLBaveModel {
  override val modelBaveLength: Double = _
  override val initialSize: Double = _
  override val terminalSize: Double = _
  override val maxSizePos: Double = _
}