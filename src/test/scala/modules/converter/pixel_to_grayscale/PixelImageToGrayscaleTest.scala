package modules.converter.pixel_to_grayscale

import models.image.{Pixel, PixelImage}
import modules.converter.pixel_image_to_grayscale.PixelImageToGrayscale
import org.scalatest.funsuite.AnyFunSuite

class PixelImageToGrayscaleTest extends AnyFunSuite{

  test("Conversion happens correctly"){
    val pixelArray = Array.ofDim[Pixel](4, 4)
    var rgb = 0
    for (x <- 0 until 4; y <- 0 until 4) {
      pixelArray(x)(y) = new Pixel(rgb ,rgb, rgb)
      rgb = rgb + 1
    }

    val pixelImageToConvert = PixelImage(pixelArray)

    val convertedImage = PixelImageToGrayscale().convert(pixelImageToConvert)

    assert(convertedImage.getHeight == pixelImageToConvert.getHeight &&
           convertedImage.getWidth == pixelImageToConvert.getWidth)
    val grayscaleValues = convertedImage.getData
    assert(grayscaleValues(0)(0) == PixelImageToGrayscale().pixelToGrayscale(pixelArray(0)(0)))
    assert(grayscaleValues(0)(1) == PixelImageToGrayscale().pixelToGrayscale(pixelArray(0)(1)))
    assert(grayscaleValues(0)(2) == PixelImageToGrayscale().pixelToGrayscale(pixelArray(0)(2)))
    assert(grayscaleValues(0)(3) == PixelImageToGrayscale().pixelToGrayscale(pixelArray(0)(3)))

  }

}
