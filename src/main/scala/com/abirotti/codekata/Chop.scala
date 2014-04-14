package com.abirotti.codekata

import scala.annotation.{switch, tailrec}
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by andrea.birotti on 12/04/2014.
 */
@RunWith(classOf[JUnit4])
object Chop {

  /**
   * Tail Recursive with accumulator and pattern matching
   * A few problems slicing the list and keeping track of the accumulated index correctly
   *
   * Not so readable
   */
  @tailrec
  def chop(int:Int, array:List[Int], indexAcc: Int = 0): Int = {
    println(s"recursive chop = $int, $array, $indexAcc")
    (array.size: @switch) match {
      case 0 => -1
      case 1 => if (int == array(0)) 0 else -1
      case x if x > 1 => {
        val mid = (array.size / 2)
        int compareTo array(mid) match{
          case 0 => mid + indexAcc
          case -1 => chop(int, array.slice(0, mid), indexAcc)
          case 1 => chop(int, array.slice(mid, array.size) , mid)
        }
      }
    }
  }

  /**
   * Imperative
   */
  def i_chop(int:Int, array:List[Int]): Int = {
    println(s"imperative chop = $int, $array")
    var result = -1
    result
  }
  /**
   * Functional Composition
   */
}
