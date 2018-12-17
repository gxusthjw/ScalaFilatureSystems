package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

object sizes extends App {
  val sizes0 = new Sizes(0, 2.8 :: 2.87 :: 2.92 :: 3.15 :: 3.23 :: 3.12 :: 3.01 :: 2.98 :: 2.88 :: 2.6 :: 2.5 :: 2.34 :: Nil)
  println(s"sizes0 = ${sizes0}")
  /*  try{
      println(s"new Sizes(-1, 2.5 :: 2.6::2.8::Nil) = ${new Sizes(-1, 2.5:: 2.6::2.8::Nil)}")
    }catch {
      case e:IllegalArgumentException => println(e.getMessage)
    }*/

  /*  try {
      println(s"new Sizes(1, 2.5 :: Nil) = ${new Sizes(1, 2.5 :: Nil)}")
    } catch {
      case e: IllegalArgumentException => println(e.getMessage)
    }*/

  val sizes1 = Sizes(1, 2.8, 2.9, 2.98, 10.2)
  println(s"sizes1 = ${sizes1}")
  val sizes2 = Sizes(2, Array(2.5, 2.6, 2.8, 2.98, 3.0))
  println(s"sizes2 = ${sizes2}")
  val sizes3 = Sizes(3, Array("2.5", "2.6", "2.8", "2.98", "3.0"), false)
  println(s"sizes3 = ${sizes3}")
  val sizes4 = Sizes(4, "2.5, 2.6, 2.8, 2.98, 3.0", ",", false)
  println(s"sizes4 = ${sizes4}")
  val sizes5 = Sizes(5, "2.5   2.6  2.8  2.98  3.0", "\\s+", false)
  println(s"sizes5 = ${sizes5}")
  val sizes6 = Sizes("6,2.5, 2.6, 2.8, 2.98, 3.0", ",")
  println(s"sizes6 = ${sizes6}")
  val sizes7 = Sizes("7  2.5   2.6  2.8  2.98  3.0")
  println(s"sizes7 = ${sizes7}")

  val sizes8 = Sizes(8, Array("2.5", "s", "2.6", "2.8", "2.98", "3.0"), true)
  println(s"sizes8 = ${sizes8}")
  val sizes9 = Sizes(9, "2.5, 2.6, 2.8, s, 2.98, 3.0", ",", true)
  println(s"sizes9 = ${sizes9}")
  val sizes10 = Sizes(10, "2.5   2.6  s  2.8  2.98  3.0", "\\s+", true)
  println(s"sizes10 = ${sizes10}")
  val sizes11 = Sizes("11,2.5, 2.6, 2.8,a, 2.98, 3.0", ",", true)
  println(s"sizes11 = ${sizes11}")
  val sizes12 = Sizes("12  2.5   2.6 s 2.8  2.98  3.0", ignore = true)
  println(s"sizes12 = ${sizes12}")

  println(s"sizes0.length = ${sizes0.length}")
  println(s"sizes0.sum = ${sizes0.sum}")
  println(s"sizes0.average = ${sizes0.average}")
  println(s"sizes0.slope = ${sizes0.slope}")
  println(s"sizes0.line = ${sizes0.line}")
  println(s"sizes0.line.sum = ${sizes0.line.sum}")
  println(s"sizes0.subLine = ${sizes0.subLine}")
  println(s"sizes0.subLine.sum = ${sizes0.subLine.sum}")
  println(s"sizes0.acvf(1, 1) = ${sizes0.acvf(1, 1)}")
  println(s"sizes0.acvf(2, 2) = ${sizes0.acvf(2, 2)}")
  println(s"sizes0.acvf(3, 3) = ${sizes0.acvf(3, 3)}")
  println(s"sizes0.acvf(4, 4) = ${sizes0.acvf(4, 4)}")
  println(s"sizes0.acvf(5, 5) = ${sizes0.acvf(5, 5)}")
}

