package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

trait TStepwise {
  val sizesAverageMean: Double
  val sizesAverageVar: Double
  val slopeMean: Double
  val slopeVar: Double
  val sizesLengthMean: Double
  var sizesLengthVar: Double
  var sizesInitialMean: Double
  var sizesInitialVar: Double
  var autoRegrCoef: Array[Double]
  var residualsMean: Double = 0.0
  var residualsVar: Double
}

class Stepwise {

}
