package modules.converter.pixel_image_to_grayscale

import models.image.{GrayscaleImage, Pixel, PixelImage}
import modules.converter.Converter

/**
 * Converts a pixel image to grayscale image
 */
class PixelImageToGrayscale extends Converter [PixelImage, GrayscaleImage]{
  /**
   * Converts a pixel image to grayscale image
   * @param pixelImage image to convert
   * @return GrayscaleImage converted from pixelImage
   */
  override def convert(pixelImage: PixelImage): GrayscaleImage = {
    val pixels = pixelImage.getData
    val grayscalePixels = Array.ofDim[Int](pixelImage.getWidth, pixelImage.getHeight)

    for (x <- 0 until pixelImage.getWidth; y <- 0 until pixelImage.getHeight) {
      grayscalePixels(x)(y) = pixelToGrayscale(pixels(x)(y))
    }

    new GrayscaleImage(grayscalePixels)
  }
  
  def pixelToGrayscale(pixel : Pixel) : Int = {
    val grayscaleValue = 0.3 * pixel.getRed + 0.59 * pixel.getGreen + 0.11 * pixel.getBlue
    grayscaleValue.toInt
  } 
}
