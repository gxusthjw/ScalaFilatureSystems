package cn.edu.gxust.jiweihuang.scala.filature.bave

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import cn.edu.gxust.jiweihuang.scala.utils._

package object sizes {

  class Sizes(val id: Int, private val data: List[Double]) {
    if (id < 0) throw new IllegalArgumentException(s"Expected the parameter {id:Int} is equal or greater than 0,but got {id=$id}.")
    if (data.length < 2) throw new IllegalArgumentException(s"Expected the parameter {data:List[Double]} of which length is equal or greater than 2,but got {data.length = ${data.length}}")

    def length: Int = data.length

    def sum: Double = data.sum

    def average: Double = sum / length

    override def toString: String = s"Sizes($id,$data)"

    def apply(index: Int): Double = data(index)
  }


  object Sizes {
    def apply(id: Int, data: Double*): Sizes = new Sizes(id, data.toList)

    def apply(id: Int, data: Array[Double]): Sizes = new Sizes(id, data.toList)

    def apply(id: Int, data: Array[String], ignore: Boolean): Sizes = {
      val tem: ArrayBuffer[Double] = new ArrayBuffer[Double]()
      if (ignore) {
        for (d <- data) yield {
          if (parse[Double](d.trim) != None) tem.+=(parse[Double](d.trim).get)
        }
      } else {
        for (d <- data) yield {
          if (parse[Double](d.trim) == None) throw new RuntimeException(s"The parameter {$d} can not be cast to double.")
          else tem.+=(parse[Double](d.trim).get)
        }
      }
      new Sizes(id, tem.toList)
    }

    def apply(id: Int, data: String, separator: String, ignore: Boolean): Sizes = apply(id, data.split(separator), ignore)

    def apply(data: String, separator: String = "\\s+", ignore: Boolean = false): Sizes = {
      val dataSplited = data.split(separator)
      if (dataSplited == null) throw new RuntimeException(s"Expected {data.split(separator)} not be null. ")
      if (dataSplited.length < 3) throw new RuntimeException(s"Expected {data.split(separator).length} is greater than or equals to 3,but got {${dataSplited.length}}.")
      val id: Int = if (parse[Int](dataSplited(0).trim) == None) throw new RuntimeException(s"The {${dataSplited(0)}} can not be cast to double.") else parse[Int](dataSplited(0).trim).get
      val data1 = for (i <- 1 to dataSplited.length - 1) yield {
        dataSplited(i)
      }
      apply(id, data1.toArray, ignore)
    }

    def unapply(arg: Sizes): Option[(Int, List[Double])] = {
      if (arg == null) None
      else Some(arg.id, arg.data)
    }
  }

  class SizesGroup(val name: String) {
    private val sizesMap = new mutable.TreeMap[Int, Sizes]()

    def +=(data: String, separator: String = "\\s+", ignore: Boolean = false): SizesGroup = {
      sizesMap.+((SizesGroup.counter, Sizes(SizesGroup.counter, data, separator, ignore)))
      SizesGroup.counter = SizesGroup.counter + 1
      this
    }

    def apply(id: Int): Sizes = get(id)

    def get(id: Int): Sizes = {
      if (sizesMap.keySet.contains(id)) sizesMap.get(id).get
      else throw new IllegalArgumentException(s"The parameter {id:Int = ${id}} is not in this sizes group.")
    }

  }

  object SizesGroup {
    private var counter: Int = 0

    def apply(name: String, data: String*): SizesGroup = {
      val sg = new SizesGroup(name)
      data.foreach(d => sg += d)
      sg
    }

  }

}
