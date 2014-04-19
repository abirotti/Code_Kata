package com.abirotti.codekata

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.scalatest.matchers.ShouldMatchers

import scala.collection.JavaConversions._
import java.util

/**
 * Created by andrea.birotti on 19/04/2014.
 */
@RunWith(classOf[JUnitRunner])
class JavaChopTest
  extends FunSuite
  with ShouldMatchers
  with BeforeAndAfterAll
{

  var jChop: JavaChop = _

  override protected def beforeAll(): Unit = {
    super.beforeAll()
    jChop = new JavaChop()
  }

  test("middle of 1, 3 is 2") {
    jChop.middle(1, 3) should be(2)
  }

  test("middle with null raises exception") {
    val exc = intercept[IllegalArgumentException] {
      jChop.middle(null, 1)
    }
    exc.getMessage should be("Provide two not-null arguments")
  }

  test("middle of 1, 100 is 50") {
    jChop.middle(1, 100) should be(50)
  }

  test("empty sequence doesn't contain 1") {
    jChop.chop(1, Nil) should be(-1)
  }

  test("List(2) sequence doesn't contain 1") {
    jChop.chop(1, util.Arrays.asList(2)) should be(-1)
  }

  test("1,3,5") {
    jChop.chop(1, util.Arrays.asList(1, 3, 5)) should be(0)
    jChop.chop(3, util.Arrays.asList(1, 3, 5)) should be(1)
    jChop.chop(5, util.Arrays.asList(1, 3, 5)) should be(2)
    jChop.chop(0, util.Arrays.asList(1, 3, 5)) should be(-1)
    jChop.chop(2, util.Arrays.asList(1, 3, 5)) should be(-1)
    jChop.chop(4, util.Arrays.asList(1, 3, 5)) should be(-1)
    jChop.chop(6, util.Arrays.asList(1, 3, 5)) should be(-1)
  }

  test("1,2,3 contains 2") {
    jChop.chop(2, util.Arrays.asList(1,2,3)) should be(1)
  }

  test("1,3,5,7") {
    jChop.chop(1, util.Arrays.asList(1, 3, 5, 7)) should be(0)
    jChop.chop(3, util.Arrays.asList(1, 3, 5, 7)) should be(1)
    jChop.chop(5, util.Arrays.asList(1, 3, 5, 7)) should be(2)
    jChop.chop(7, util.Arrays.asList(1, 3, 5, 7)) should be(3)
    jChop.chop(0, util.Arrays.asList(1, 3, 5, 7)) should be(-1)
    jChop.chop(2, util.Arrays.asList(1, 3, 5, 7)) should be(-1)
    jChop.chop(4, util.Arrays.asList(1, 3, 5, 7)) should be(-1)
    jChop.chop(6, util.Arrays.asList(1, 3, 5, 7)) should be(-1)
  }
}
