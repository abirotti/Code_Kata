package com.abirotti.codekata

import scala.io.Source

/**
 * Created by andrea.birotti on 21/04/2014.
 */
object DataMunging {

  private def extractFromArray(current: Array[String]) : (Int, Int, Int) = {
    val notNums: String = "[^\\p{L}\\p{Nd}]"
    (
      current(0).toInt,
      current(1).replaceAll(notNums, "").toInt,
      current(2).replaceAll(notNums, "").toInt
      )
  }
  def weatherData(): Int = {

    var cand: (Int, Int) = (0, 0)

    for(line <- (Source.fromInputStream(getClass.getResourceAsStream("/weather.dat"))).getLines
        if line.trim.size > 0 && Character.isDigit(line.trim.charAt(0))) {
      val current = line.trim.split("\\s+")
      val (no, high, low) = extractFromArray(current)

      if (cand._1 == 0 || cand._2 > high-low)
        cand = (no, high-low)
    }

    cand._1
  }

}
