package modules.filter.grayscale_image_filter

import models.image.GrayscaleImage

/**
 * @param axis if XAXIS, flips by XAXIS, if YAXIS, flips by YAXIS
 */
class FlipFilter(axis: Axis) extends GrayscaleImageFilter {
  /**
   * Original:
   * AB
   * CD
   *
   * Flip on x-axes:
   * CD
   * AB
   *
   * Flip on y-axes:
   * BA
   * DC
   *
   * @param input grayscaleImage to flip
   * @return flipped grayscaleImage
   */
  override def apply(input: GrayscaleImage): GrayscaleImage = {
    val (pixels, width, height ) = input.getDimensionsAndData
    val flippedPixels = Array.ofDim[Int](width, height)

    axis match {
      case Axis.XAXIS =>
        for (y <- 0 until height; x <- 0 until width) {
          flippedPixels(x)(height - y - 1) = pixels(x)(y)
        }
      case Axis.YAXIS =>
        for (y <- 0 until height; x <- 0 until width) {
          flippedPixels(width - x - 1)(y) = pixels(x)(y)
        }
    }

    new GrayscaleImage(flippedPixels)
  }
}
