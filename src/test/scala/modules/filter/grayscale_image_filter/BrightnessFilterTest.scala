package modules.filter.grayscale_image_filter

import models.image.GrayscaleImage
import modules.filter.grayscale_image_filter.BrightnessFilter
import org.scalatest.funsuite.AnyFunSuite

class BrightnessFilterTest extends AnyFunSuite{
  test("Should brighten the image by a positive value") {
    val originalPixel = 100
    val brightnessValue = 50
    val expectedPixel = 150

    val filteredPixel = BrightnessFilter(brightnessValue)(GrayscaleImage(Array(Array(originalPixel)))).getData.head.head

    assert(filteredPixel == expectedPixel)
  }

  test("Should cap brightened pixel value to 255") {
    val originalPixel = 200
    val brightnessValue = 100
    val expectedPixel = 255

    val filteredPixel = BrightnessFilter(brightnessValue)(GrayscaleImage(Array(Array(originalPixel)))).getData.head.head

    assert(filteredPixel == expectedPixel)
  }

  test("Should cap darkened pixel value to 0") {
    val originalPixel = 50
    val brightnessValue = -100
    val expectedPixel = 0

    val filteredPixel = BrightnessFilter(brightnessValue)(GrayscaleImage(Array(Array(originalPixel)))).getData.head.head

    assert(filteredPixel == expectedPixel)
  }
}
