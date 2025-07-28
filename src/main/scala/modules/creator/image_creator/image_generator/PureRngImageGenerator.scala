package modules.creator.image_creator.image_generator

import models.image.{Pixel, PixelImage}

import scala.util.Random

/**
 * Generates random images with random dimensions between MIN_DIMENSION and MAX_DIMENSION
 */
class PureRngImageGenerator extends ImageGenerator{

  /**
   *  @return PixelImage with random dimensions between MIN_DIMENSION and MAX_DIMENSION
   */
  override def create(): PixelImage = {

      val random = new Random()
      val width = random.between(MIN_DIMENSION, MAX_DIMENSION)
      val height = random.between(MIN_DIMENSION, MAX_DIMENSION)

      val pixels = Array.ofDim[Pixel](width, height)

      for (x <- 0 until width; y <- 0 until height) {
        val r = random.between(0, 255)
        val g = random.between(0, 255)
        val b = random.between(0, 255)
        pixels(x)(y) = new Pixel(r, g, b)
      }

      new PixelImage(pixels)

    }

}
