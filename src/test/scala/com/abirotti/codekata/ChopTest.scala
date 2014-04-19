package com.abirotti.codekata

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * Created by andrea.birotti on 12/04/2014.
 */
@RunWith(classOf[JUnitRunner])
class ChopTest
  extends FunSuite
  with ShouldMatchers
  with BeforeAndAfterAll
{

  test("empty sequence doesn't contain 1") {
    Chop.chop(1, Nil) should be(-1)
  }

  test("List(2) sequence doesn't contain 1") {
    Chop.chop(1, List(2)) should be(-1)
  }

  test("1,3,5") {
    Chop.chop(1, List(1, 3, 5)) should be(0)
    Chop.chop(3, List(1, 3, 5)) should be(1)
    Chop.chop(5, List(1, 3, 5)) should be(2)
    Chop.chop(0, List(1, 3, 5)) should be(-1)
    Chop.chop(2, List(1, 3, 5)) should be(-1)
    Chop.chop(4, List(1, 3, 5)) should be(-1)
    Chop.chop(6, List(1, 3, 5)) should be(-1)
  }

  test("1,2,3 contains 2") {
    Chop.chop(2, List(1,2,3)) should be(1)
  }

  test("1,3,5,7") {
    Chop.chop(1, List(1, 3, 5, 7)) should be(0)
    Chop.chop(3, List(1, 3, 5, 7)) should be(1)
    Chop.chop(5, List(1, 3, 5, 7)) should be(2)
    Chop.chop(7, List(1, 3, 5, 7)) should be(3)
    Chop.chop(0, List(1, 3, 5, 7)) should be(-1)
    Chop.chop(2, List(1, 3, 5, 7)) should be(-1)
    Chop.chop(4, List(1, 3, 5, 7)) should be(-1)
    Chop.chop(6, List(1, 3, 5, 7)) should be(-1)
  }

}
