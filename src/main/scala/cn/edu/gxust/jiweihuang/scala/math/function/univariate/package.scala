package cn.edu.gxust.jiweihuang.scala.math.function

package object univariate {

  import org.hipparchus.analysis.UnivariateFunction

  trait TUnivariateFunction extends UnivariateFunction
    with Serializable {
    val formula: String
  }

  trait TUnivariateInverseFunction extends TUnivariateFunction {
    def inverse(x: Double): Array[Double]
  }

  trait TUnivariateDerivativeFunction extends TUnivariateFunction {
    def derivative(x: Double): Double
  }

  import org.hipparchus.analysis.differentiation.{
    DSFactory,
    UnivariateDifferentiableFunction
  }

  trait TUnivariateDifferentiableFunction extends TUnivariateFunction
    with UnivariateDifferentiableFunction {

    def differential(x: Double, order: Int = 1): Double = {
      value(new DSFactory(1,
        order).variable(0,
        x)).getPartialDerivative(1)
    }
  }

  trait TUnivariateIntegralFunction extends TUnivariateFunction {
    //val integralConstant = 0.0
    def integrate(x: Double): Double

    //definite integration
    def integrate(lowerX: Double, upperX: Double): Double =
      integrate(upperX) - integrate(lowerX)
  }

  import org.hipparchus.analysis.integration._

  trait TUnivariateIntegrableFunction
    extends TUnivariateFunction {

    private[this] val DefaultIntegrationPointsNumber = 32

    def integrateRomberg(lowerX: Double, upperX: Double, maxIter: Int = Int.MaxValue,
                         relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                         absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                         minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                         maximalIterationCount: Int = RombergIntegrator.ROMBERG_MAX_ITERATIONS_COUNT
                        ): Double =
      new RombergIntegrator(relativeAccuracy, absoluteAccuracy,
        minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

    def integrateSimpson(lowerX: Double, upperX: Double, maxIter: Int = Int.MaxValue,
                         relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                         absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                         minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                         maximalIterationCount: Int = SimpsonIntegrator.SIMPSON_MAX_ITERATIONS_COUNT
                        ): Double =
      new SimpsonIntegrator(relativeAccuracy, absoluteAccuracy,
        minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

    def integrateMidPoint(lowerX: Double, upperX: Double, maxIter: Int = Int.MaxValue,
                          relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                          absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                          minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                          maximalIterationCount: Int = MidPointIntegrator.MIDPOINT_MAX_ITERATIONS_COUNT
                         ): Double =
      new MidPointIntegrator(relativeAccuracy, absoluteAccuracy,
        minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

    def integrateTrapezoid(lowerX: Double, upperX: Double, maxIter: Int = Int.MaxValue,
                           relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                           absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                           minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                           maximalIterationCount: Int = TrapezoidIntegrator.TRAPEZOID_MAX_ITERATIONS_COUNT
                          ): Double =
      new TrapezoidIntegrator(relativeAccuracy, absoluteAccuracy,
        minimalIterationCount, maximalIterationCount).integrate(maxIter, this, lowerX, upperX)

    def integrateIterativeLegendreGauss(lowerX: Double, upperX: Double, maxIter: Int = Int.MaxValue,
                                        integrationPointsNumber: Int = DefaultIntegrationPointsNumber,
                                        relativeAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY,
                                        absoluteAccuracy: Double = BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY,
                                        minimalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT,
                                        maximalIterationCount: Int = BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT
                                       ): Double =
      new IterativeLegendreGaussIntegrator(integrationPointsNumber,
        relativeAccuracy, absoluteAccuracy, minimalIterationCount,
        maximalIterationCount).integrate(maxIter, this, lowerX, upperX)
  }

}
