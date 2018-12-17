package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

object sizes_group extends App {
  println(s"SizesGroup.TEST10030 = ${SizesGroup.TEST10010}")
  println(s"SizesGroup.TEST10030 = ${SizesGroup.TEST10030}")
  println(s"SizesGroup.ZJJX10050 = ${SizesGroup.ZJJX10050}")
  println(s"SizesGroup.GXHX10050 = ${SizesGroup.GXHX10050}")
  println(s"SizesGroup.GXLC50210 = ${SizesGroup.GXLC50210}")
  println(s"SizesGroup.GXRA50200 = ${SizesGroup.GXRA50200}")
  println(s"SizesGroup.TEST10010.count=${SizesGroup.TEST10010.count}")
  println(SizesGroup.TEST10010.acvfStringArray(5).foreach(println(_)))
  println(SizesGroup.TEST10010.acvfStringMatrix(5).foreach(s => println(s.toList)))
  println(SizesGroup.TEST10010.acvfVector(5))
  println(SizesGroup.TEST10010.acvfArray(5).foreach(println(_)))
  println(SizesGroup.TEST10010.acvf2DArray(5).foreach(s => println(s.toList)))
  println(SizesGroup.TEST10010.acvfMatrix(5))
  println(SizesGroup.TEST10010.coefArray(5).foreach(println(_)))
  println(SizesGroup.TEST10010.coefVector(5))
}
