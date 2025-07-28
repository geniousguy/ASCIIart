package ui.extractor

import modules.filter.grayscale_image_filter.Axis.{XAXIS, YAXIS}
import modules.filter.grayscale_image_filter.{BrightnessFilter, FlipFilter, InvertFilter}
import org.scalatest.funsuite.AnyFunSuite

class GrayscaleImageFilterExtractorTest extends AnyFunSuite{
  val extractor = new GrayscaleImageFilterExtractor


  test("One filter gets extracted"){
    val arguments2 = List("--invert")
    val (filters2, remainingArguments2) = extractor.extract(arguments2)
    assert(filters2.size == 1)

  }
  test("Two filters get extracted"){
    val arguments3 = List("--flip", "y", "--brightness", "-10")
    val (filters3, remainingArguments3) = extractor.extract(arguments3)
    assert(filters3.size == 2)

  }
  test("3 filters get extracted") {
    val arguments1 = List("--invert", "--flip", "x", "--brightness", "20")
    val (filters1, remainingArguments1) = extractor.extract(arguments1)
    assert(filters1.size == 3)
  }
  test("Invalid flip argument") {
    val arguments1 = List("--flip", "z")
    assertThrows[IllegalArgumentException](extractor.extract(arguments1))
  }
  test("Invalid filter name") {
    val arguments2 = List("--unknown-filter")
    assertThrows[IllegalArgumentException](extractor.extract(arguments2))
  }
  test("Missing brightness argument"){
    val arguments3 = List("--brightness")
    assertThrows[IllegalArgumentException](extractor.extract(arguments3))
  }
}
