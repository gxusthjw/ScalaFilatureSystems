package cn.edu.gxust.jiweihuang.scala

package object utils {
  /**
    * @param s string
    * @tparam T class type
    * @return option
    */
  def parse[T: ParseOp](s: String): Option[T] = {
    try {
      Some(implicitly[ParseOp[T]].op(s))
    } catch {
      case _ => None
    }
  }

  /** Implicitly converts type classes */
  case class ParseOp[T](op: String => T)

  implicit val popDouble = ParseOp[Double](_.toDouble)
  implicit val popInt = ParseOp[Int](_.toInt)
  implicit val popLong = ParseOp[Long](_.toLong)
  implicit val popFloat = ParseOp[Float](_.toFloat)

}
