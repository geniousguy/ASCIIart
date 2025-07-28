package modules.filter.grayscale_image_filter

import models.image.GrayscaleImage
import modules.filter.grayscale_image_filter.InvertFilter
import org.scalatest.funsuite.AnyFunSuite

class InvertFilterTest extends AnyFunSuite{
  test("Should invert a single pixel value") {
    val originalPixel = 100
    val expectedPixel = 255 - originalPixel

    val filteredPixel = InvertFilter()(GrayscaleImage(Array(Array(originalPixel)))).getData.head.head

    assert(filteredPixel == expectedPixel)
  }

  test("Should invert pixels at the maximum value (255)") {
    val originalPixel = 255
    val expectedPixel = 0

    val filteredPixel = InvertFilter()(GrayscaleImage(Array(Array(originalPixel)))).getData.head.head

    assert(filteredPixel == expectedPixel)
  }
}
