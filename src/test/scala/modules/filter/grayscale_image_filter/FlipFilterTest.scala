package modules.filter.grayscale_image_filter

import models.image.GrayscaleImage
import org.scalatest.funsuite.AnyFunSuite

class FlipFilterTest extends AnyFunSuite{
  test("Should flip a 2x2 image on the X-axis") {
    val originalPixels = Array(Array(1, 2), Array(3, 4))
    val expectedPixels = Array(Array(3, 4), Array(1, 2))

    val flippedImage = FlipFilter(Axis.YAXIS).apply(GrayscaleImage(originalPixels))

    assert(flippedImage.getData === expectedPixels)
  }

  test("Should flip a 2x2 image on the Y-axis") {
    val originalPixels = Array(Array(1, 2), Array(3, 4))
    val expectedPixels = Array(Array(2, 1), Array(4, 3))

    val flippedImage = FlipFilter(Axis.XAXIS).apply(GrayscaleImage(originalPixels))

    assert(flippedImage.getData === expectedPixels)
  }
}
