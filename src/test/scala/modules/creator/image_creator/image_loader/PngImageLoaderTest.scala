package modules.creator.image_creator.image_loader

import models.image.Pixel
import modules.creator.image_creator.image_loader.PngImageLoader
import org.scalatest.funsuite.AnyFunSuite

class PngImageLoaderTest extends AnyFunSuite{
  test("Loading invalid path") {
    val invalidPath = "susPath"
    val thrown = intercept[Exception] {
      PngImageLoader(invalidPath).create()
    }
  }

  test("Creation") {
    val image0 = PngImageLoader("src/images/png_orange.png").create()
    assert(image0.getWidth == 640)
    assert(image0.getHeight == 492)

    val pixel1 = new Pixel(0, 0, 0)
    assert(image0.getPixel(0, 0).equals(pixel1))

    val pixel2 = new Pixel(216, 155, 29)
    assert(image0.getPixel(350, 250).equals(pixel2))

    val pixel3 = new Pixel(212, 146, 0)
    assert(image0.getPixel(300, 200).equals(pixel3))

  }
}
