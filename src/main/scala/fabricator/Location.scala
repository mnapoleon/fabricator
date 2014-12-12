package fabricator

import scala.util.Random

class Location(private val utility: UtilityService,
               private val alpha: Alphanumeric,
               private val random: Random) {


  def this() = {
    this(new UtilityService(), new Alphanumeric, new Random());

  }

  def altitude(): String = {
    altitude(8848, 5)
  }

  def altitude(max: Int): String = {
    altitude(max, 5)
  }

  def altitude(max: Int, accuracy: Int): String = {
    if (accuracy > 10) {
      throw new IllegalArgumentException("Accuracy cannot be more then 10 digits")
    }
    alpha.integer(0,max) + "." + alpha.integer(100000, 1000000000).toString.substring(0, accuracy)
  }

  def depth(): String = {
    depth(-2550, 5)
  }

  def depth(min: Int): String = {
    depth(min, 5)
  }

  def depth(min: Int, accuracy: Int): String = {
    if (accuracy > 10) {
      throw new IllegalArgumentException("Accuracy cannot be more then 10 digits")
    }
    "-"+alpha.integer(0, Math.abs(min)) + "." + alpha.integer(100000, 1000000000).toString.substring(0, accuracy)
  }

  def coordinates(): String = {
    latitude() + ", " + longitude()
  }

  def coordinates(accuracy: Int): String = {
    latitude(accuracy) + ", " + longitude(accuracy)
  }


  def latitude(): String = {
    latitude(-90, 90)
  }

  def latitude(min: Int, max: Int): String = {
    latitude(min, max, 5)
  }

  def latitude(accuracy: Int): String = {
    latitude(-90, 90, accuracy)
  }

  def latitude(min: Int, max: Int, accuracy: Int): String = {
    if (accuracy > 10) {
      throw new IllegalArgumentException("Accuracy cannot be more then 10 digits")
    }
    alpha.integer(min, max) + "." + alpha.integer(100000, 1000000000).toString.substring(0, accuracy)
  }


  def longitude(): String = {
    longitude(-180, 180)
  }

  def longitude(min: Int, max: Int): String = {
    longitude(min, max, 5)
  }

  def longitude(accuracy: Int): String = {
    longitude(-180, 180, accuracy)
  }

  def longitude(min: Int, max: Int, accuracy: Int): String = {
    if (accuracy > 10) {
      throw new IllegalArgumentException("Accuracy cannot be more then 10 digits")
    }
    alpha.integer(min, max) + "." + alpha.integer(100000, 1000000000).toString.substring(0, accuracy)
  }


}
