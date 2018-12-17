package cn.edu.gxust.jiweihuang.scala.math.function.univariate

import cn.edu.gxust.jiweihuang.scala.test.UnitSpec

class TQuadraticVertexTest extends UnitSpec {
  val qv1 = TQuadraticVertex()
  val qv2 = TQuadraticVertex(1, 2, 5)
  val qv3 = TQuadraticVertex(-1, 0, 1)
  val qv4 = TQuadraticVertex(-5, 10, -10)
  val qv5 = TQuadraticVertex(-10, 100, 200)

  "TQuadraticVertex.quadraticVertex" should "be equals to right value." in {
    assert(TQuadraticVertex.quadraticVertex()(2) == 4)
    assert(TQuadraticVertex.quadraticVertex()(3) == 9)
    assert(TQuadraticVertex.quadraticVertex()(5) == 25)
    assert(qv1.value(2) == TQuadraticVertex.quadraticVertex()(2))
    assert(qv1.value(3) == TQuadraticVertex.quadraticVertex()(3))
    assert(qv1.value(5) == TQuadraticVertex.quadraticVertex()(5))

    assert(TQuadraticVertex.quadraticVertex(1, 2, 5)(2) == 5)
    assert(TQuadraticVertex.quadraticVertex(1, 2, 5)(3) == 6)
    assert(TQuadraticVertex.quadraticVertex(1, 2, 5)(5) == 14)
    assert(qv2.value(2) == TQuadraticVertex.quadraticVertex(1, 2, 5)(2))
    assert(qv2.value(3) == TQuadraticVertex.quadraticVertex(1, 2, 5)(3))
    assert(qv2.value(5) == TQuadraticVertex.quadraticVertex(1, 2, 5)(5))

    assert(TQuadraticVertex.quadraticVertex(-1, 0, 1)(2) == -3)
    assert(TQuadraticVertex.quadraticVertex(-1, 0, 1)(3) == -8)
    assert(TQuadraticVertex.quadraticVertex(-1, 0, 1)(5) == -24)
    assert(qv3.value(2) == TQuadraticVertex.quadraticVertex(-1, 0, 1)(2))
    assert(qv3.value(3) == TQuadraticVertex.quadraticVertex(-1, 0, 1)(3))
    assert(qv3.value(5) == TQuadraticVertex.quadraticVertex(-1, 0, 1)(5))

    assert(TQuadraticVertex.quadraticVertex(-5, 10, -10)(2) == -330)
    assert(TQuadraticVertex.quadraticVertex(-5, 10, -10)(3) == -255)
    assert(TQuadraticVertex.quadraticVertex(-5, 10, -10)(5) == -135)
    assert(qv4.value(2) == TQuadraticVertex.quadraticVertex(-5, 10, -10)(2))
    assert(qv4.value(3) == TQuadraticVertex.quadraticVertex(-5, 10, -10)(3))
    assert(qv4.value(5) == TQuadraticVertex.quadraticVertex(-5, 10, -10)(5))

    assert(TQuadraticVertex.quadraticVertex(-10, 100, 200)(2) == -95840)
    assert(TQuadraticVertex.quadraticVertex(-10, 100, 200)(3) == -93890)
    assert(TQuadraticVertex.quadraticVertex(-10, 100, 200)(5) == -90050)
    assert(qv5.value(2) == TQuadraticVertex.quadraticVertex(-10, 100, 200)(2))
    assert(qv5.value(3) == TQuadraticVertex.quadraticVertex(-10, 100, 200)(3))
    assert(qv5.value(5) == TQuadraticVertex.quadraticVertex(-10, 100, 200)(5))

  }

  "TQuadraticVertex.quadraticVertexInverse" should "be equals to right value." in {
    assert(TQuadraticVertex.quadraticVertexInverse()(7)(0) + 2.645751 < 1e-6)
    assert(TQuadraticVertex.quadraticVertexInverse()(7)(1) - 2.645751 < 1e-6)
    println(s"TQuadraticVertex.quadraticVertexInverse()(7).toList = ${TQuadraticVertex.quadraticVertexInverse()(7).toList}")
    assert(TQuadraticVertex.quadraticVertex()(TQuadraticVertex.quadraticVertexInverse()(7)(0)) == TQuadraticVertex.quadraticVertex()(TQuadraticVertex.quadraticVertexInverse()(7)(1)))
    println(s"TQuadraticVertex.quadraticVertexInverse(1, 2, 5)(7).toList = ${TQuadraticVertex.quadraticVertexInverse(1, 2, 5)(7).toList}")
    assert(TQuadraticVertex.quadraticVertex(1, 2, 5)(TQuadraticVertex.quadraticVertexInverse(1, 2, 5)(7)(0)) == TQuadraticVertex.quadraticVertex(1, 2, 5)(TQuadraticVertex.quadraticVertexInverse(1, 2, 5)(7)(1)))
    println(s"TQuadraticVertex.quadraticVertexInverse(-1, 0, 1)(-3).toList = ${TQuadraticVertex.quadraticVertexInverse(-1, 0, 1)(-3).toList}")
    assert(TQuadraticVertex.quadraticVertex(-1, 0, 1)(TQuadraticVertex.quadraticVertexInverse(-1, 0, 1)(-3)(0)) == TQuadraticVertex.quadraticVertex(-1, 0, 1)(TQuadraticVertex.quadraticVertexInverse(-1, 0, 1)(-3)(1)))
    println(s"TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(20).toList = ${TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(20).toList}")
    println(s"TQuadraticVertex.quadraticVertexInverse(-10, 100, 200)(-100).toList = ${TQuadraticVertex.quadraticVertexInverse(-10, 100, 200)(-100).toList}")
    assert(TQuadraticVertex.quadraticVertex(-10, 100, 200)(TQuadraticVertex.quadraticVertexInverse(-10, 100, 200)(-100)(0)) == TQuadraticVertex.quadraticVertex(-10, 100, 200)(TQuadraticVertex.quadraticVertexInverse(-10, 100, 200)(-100)(1)))
    println(s"TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(0).toList = ${TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(0).toList}")
    println(s"TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(-1).toList = ${TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(-1).toList}")
    println(s"TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(-10).toList = ${TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(-10).toList}")
    println(s"TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(-20).toList = ${TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(-20).toList}")
    //数组的相等性比较，不能使用 == 或 .equals() 而是用sameElements
    assert(qv1.inverse(2).sameElements(TQuadraticVertex.quadraticVertexInverse()(2)))
    assert(qv2.inverse(-5).sameElements(TQuadraticVertex.quadraticVertexInverse(1, 2, 5)(-5)))
    assert(qv3.inverse(6).sameElements(TQuadraticVertex.quadraticVertexInverse(-1, 0, 1)(6)))
    assert(qv4.inverse(200).sameElements(TQuadraticVertex.quadraticVertexInverse(-5, 10, -10)(200)))
    assert(qv5.inverse(1200).sameElements(TQuadraticVertex.quadraticVertexInverse(-10, 100, 200)(1200)))
  }

  "TQuadraticVertex.quadraticVertexDerivative" should "be equals to right value." in {
    assert(TQuadraticVertex.quadraticVertexDerivative()(2) == 4)
    println(s"TQuadraticVertex.quadraticVertexDerivative()(2)=${TQuadraticVertex.quadraticVertexDerivative()(2)}")
    assert(TQuadraticVertex.quadraticVertexDerivative()(2) == qv1.derivative(2))
    assert(TQuadraticVertex.quadraticVertexDerivative()(2) == qv1.differential(2))

    assert(TQuadraticVertex.quadraticVertexDerivative(1, 2, 5)(3) == qv2.derivative(3))
    assert(TQuadraticVertex.quadraticVertexDerivative(1, 2, 5)(3) == qv2.differential(3))

    assert(TQuadraticVertex.quadraticVertexDerivative(-1, 0, 1)(-5) == qv3.derivative(-5))
    assert(TQuadraticVertex.quadraticVertexDerivative(-1, 0, 1)(-5) == qv3.differential(-5))

    assert(TQuadraticVertex.quadraticVertexDerivative(-5, 10, -10)(6) == qv4.derivative(6))
    assert(TQuadraticVertex.quadraticVertexDerivative(-5, 10, -10)(6) == qv4.differential(6))

    assert(TQuadraticVertex.quadraticVertexDerivative(-10, 100, 200)(12) == qv5.derivative(12))
    assert(TQuadraticVertex.quadraticVertexDerivative(-10, 100, 200)(12) == qv5.differential(12))
  }

  "TQuadraticVertex.quadraticVertexIntegrate" should "be equals to right value." in {
    println(s"TQuadraticVertex.quadraticVertexIntegrate()(2) = ${TQuadraticVertex.quadraticVertexIntegrate()(2)}")
    assert(TQuadraticVertex.quadraticVertexIntegrate()(2) == qv1.integrate(2))
    println(s"qv1.integrate(-2,2) = ${qv1.integrate(-2, 2)}")
    println(s"qv1.integrateRomberg(-2,2) = ${qv1.integrateRomberg(-2, 2)}")
    println(s"qv1.integrateSimpson(-2, 2) = ${qv1.integrateSimpson(-2, 2)}")
    println(s"qv1.integrateTrapezoid(-2, 2) = ${qv1.integrateTrapezoid(-2, 2)}")
    println(s"qv1.integrateMidPoint(-2, 2) = ${qv1.integrateMidPoint(-2, 2)}")
    println(s"qv1.integrateIterativeLegendreGauss(-2, 2) = ${qv1.integrateIterativeLegendreGauss(-2, 2)}")

    assert(TQuadraticVertex.quadraticVertexIntegrate(1, 2, 5)(7) == qv2.integrate(7))
    assert(TQuadraticVertex.quadraticVertexIntegrate(-1, 0, 1)(-3) == qv3.integrate(-3))
    assert(TQuadraticVertex.quadraticVertexIntegrate(-5, 10, -10)(200) == qv4.integrate(200))
    assert(TQuadraticVertex.quadraticVertexIntegrate(-10, 100, 200)(22) == qv5.integrate(22))

    println(s"qv2.integrate(-2,2) = ${qv2.integrate(-2, 2)}")
    println(s"qv2.integrateRomberg(-2,2) = ${qv2.integrateRomberg(-2, 2)}")
    println(s"qv2.integrateSimpson(-2, 2) = ${qv2.integrateSimpson(-2, 2)}")
    println(s"qv2.integrateTrapezoid(-2, 2) = ${qv2.integrateTrapezoid(-2, 2)}")
    println(s"qv2.integrateMidPoint(-2, 2) = ${qv2.integrateMidPoint(-2, 2)}")
    println(s"qv2.integrateIterativeLegendreGauss(-2, 2) = ${qv2.integrateIterativeLegendreGauss(-2, 2)}")

    println(s"qv3.integrate(-2,2) = ${qv3.integrate(-2, 2)}")
    println(s"qv3.integrateRomberg(-2,2) = ${qv3.integrateRomberg(-2, 2)}")
    println(s"qv3.integrateSimpson(-2, 2) = ${qv3.integrateSimpson(-2, 2)}")
    println(s"qv3.integrateTrapezoid(-2, 2) = ${qv3.integrateTrapezoid(-2, 2)}")
    println(s"qv3.integrateMidPoint(-2, 2) = ${qv3.integrateMidPoint(-2, 2)}")
    println(s"qv3.integrateIterativeLegendreGauss(-2, 2) = ${qv3.integrateIterativeLegendreGauss(-2, 2)}")

    println(s"qv4.integrate(-20, 20) = ${qv4.integrate(-20, 20)}")
    println(s"qv4.integrateRomberg(-20, 20) = ${qv4.integrateRomberg(-20, 20)}")
    println(s"qv4.integrateSimpson(-20, 20) = ${qv4.integrateSimpson(-20, 20)}")
    println(s"qv4.integrateTrapezoid(-20, 20) = ${qv4.integrateTrapezoid(-20, 20)}")
    println(s"qv4.integrateMidPoint(-20, 20) = ${qv4.integrateMidPoint(-20, 20)}")
    println(s"qv4.integrateIterativeLegendreGauss(-20, 20) = ${qv4.integrateIterativeLegendreGauss(-20, 20)}")

    println(s"qv5.integrate(0,100) = ${qv5.integrate(0, 100)}")
    println(s"qv5.integrateRomberg(0,100) = ${qv5.integrateRomberg(0, 100)}")
    println(s"qv5.integrateSimpson(0,100) = ${qv5.integrateSimpson(0, 100)}")
    println(s"qv5.integrateTrapezoid(0,100) = ${qv5.integrateTrapezoid(0, 100)}")
    println(s"qv5.integrateMidPoint(0,100) = ${qv5.integrateMidPoint(0, 100)}")
    println(s"qv5.integrateIterativeLegendreGauss(0,100) = ${qv5.integrateIterativeLegendreGauss(0, 100)}")
    //对比发现：
    //对于二次函数，Romberg和Simpson较准确，且比较快，而IterativeLegendreGauss准确度稍差，但慢，而Trapezoid和MidPoint不够准确
  }
}
