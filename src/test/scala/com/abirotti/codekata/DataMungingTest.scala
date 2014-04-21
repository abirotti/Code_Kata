package com.abirotti.codekata

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created by andrea.birotti on 21/04/2014.
 */
@RunWith(classOf[JUnitRunner])
class DataMungingTest
  extends FunSuite
  with ShouldMatchers
{
  test("weather") {
    DataMunging.weatherData() should be(14)
  }
}
