package modules.filter.grayscale_image_filter

import models.image.GrayscaleImage

/**
 * Inverts the colors of the image
 */
class InvertFilter extends GrayscaleImageFilter {

  /**
   * Inverts the colors of the image
   * @param grayscaleImage image to invert
   * @return image with inverted colors
   */
  override def apply(grayscaleImage: GrayscaleImage): GrayscaleImage = {
    val grayscalePixels = grayscaleImage.getData

    val invertedPixels = grayscalePixels.map { row =>
      row.map { pixel =>
        255 - pixel
      }
    }

    new GrayscaleImage(invertedPixels)
  }
}
