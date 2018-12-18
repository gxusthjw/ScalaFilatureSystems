package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

object stepwise_script extends App {
  val sizes0 = SizesGroup.TEST10010(0)
  println(s"sizes0 = $sizes0")
  val sizesGroup0 = new SizesGroup("tem").update(sizes0)
  println(sizesGroup0)
  println(sizesGroup0.coefArray(1).foreach(println(_)))
  println(sizesGroup0.coefArray(2).foreach(println(_)))
  println(sizesGroup0.coefArray(3).foreach(println(_)))
  println(sizesGroup0.coefArray(4).foreach(println(_)))
  println(sizesGroup0.coefArray(5).foreach(println(_)))

  val stepwiseModel = new StepwiseRegrModel(sizesGroup0.coefArray(6))
  println(stepwiseModel.differInitial(sizes0.average, sizes0.slope, sizes0.length, sizes0.initial))
  println(stepwiseModel.differ(sizes0.average, sizes0.slope, sizes0.length, sizes0.initial).foreach(println(_)))
  println(stepwiseModel.getSizes(0, sizes0.average, sizes0.slope, sizes0.length, sizes0.initial))
  println(sizes0)
}
