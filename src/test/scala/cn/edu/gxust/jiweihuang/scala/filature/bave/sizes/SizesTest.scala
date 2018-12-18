package cn.edu.gxust.jiweihuang.scala.filature.bave.sizes

import cn.edu.gxust.jiweihuang.scala.test.UnitSpec

class SizesTest extends UnitSpec {
  "Primary constructor of Sizes" should "throw new IllegalArgumentException when {id < 0}" in {
    assertThrows[IllegalArgumentException](new Sizes(-2, List(2.77, 3.16, 3.24, 3.25, 3.24, 3.05, 3.02, 2.60, 2.35, 2.01, 1.81, 1.71)))
    assertThrows[IllegalArgumentException](Sizes(-1, "2.77 3.16 3.24 3.25 3.24 3.05 3.02 2.60 2.35 2.01 1.81 1.71", "\\s+", false))
    //assertThrows[IllegalArgumentException](new Sizes(0, List(2.77, 3.16, 3.24, 3.25, 3.24, 3.05, 3.02, 2.60, 2.35, 2.01, 1.81, 1.71)))
    //assertThrows[IllegalArgumentException](Sizes(1, "2.77 3.16 3.24 3.25 3.24 3.05 3.02 2.60 2.35 2.01 1.81 1.71", "\\s+", false))
  }

  "Primary constructor of Sizes" should "throw new IllegalArgumentException when {data.length >= 2}" in {
    assertThrows[IllegalArgumentException](new Sizes(0, List()))
    assertThrows[IllegalArgumentException](new Sizes(2, List(2.0)))
    //assertThrows[IllegalArgumentException](new Sizes(3, List(2.0, 3.0)))
  }

  "The some instance of Sizes" should "be constructed correctly" in {
    assertResult(Sizes.TEST10010Average)(Sizes(1001, "2.77 3.16 3.24 3.25 3.24 3.05 3.02 2.60 2.35 2.01 1.81 1.71", "\\s+", false))
    assertResult(Sizes.TEST10030Average)(new Sizes(1002, List(2.44, 2.75, 2.90, 2.86, 2.72, 2.57, 2.50, 2.11, 1.93, 1.75, 1.59)))
    assertResult(Sizes.ZJJX10050Average)(Sizes(1003, Array(3.53, 3.50, 3.33, 3.15, 2.88, 2.58, 2.27, 1.95, 1.77, 1.55, 1.80, 1.48)))
    assertResult(Sizes.GXHX10050Average)(Sizes("1004  3.72 3.84 3.75 3.62 3.38 3.06 2.56 2.14 1.87 1.72 1.07", "\\s+", false))
    assertResult(Sizes.GXLC50210Average)(Sizes(1005, 3.17, 3.29, 3.33, 3.26, 3.17, 3.00, 2.84, 2.58, 2.36, 2.10, 1.90, 1.71, 1.58, 1.44, 1.33, 1.30, 1.29, 1.23, 1.26, 1.17))
    assertResult(Sizes.GXRA50200Average)(Sizes(1006, Array("2.89", "3.03", "3.05", "2.99", "2.89", "2.78", "2.60", "2.41", "2.13", "1.91", "1.66", "1.51", "1.34", "1.25", "1.14", "1.11", "1.10", "1.08", "0.85", "1.53"), false))
  }

  "The length of Sizes" should "be equals to right value" in {
    assertResult(Sizes.TEST10010Average.length)(12)
    assertResult(Sizes.TEST10030Average.length)(11)
    assertResult(Sizes.ZJJX10050Average.length)(12)
    assertResult(Sizes.GXHX10050Average.length)(11)
    assertResult(Sizes.GXLC50210Average.length)(20)
    assertResult(Sizes.GXRA50200Average.length)(20)
  }


}
