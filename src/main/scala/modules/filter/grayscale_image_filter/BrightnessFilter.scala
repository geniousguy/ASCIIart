package modules.filter.grayscale_image_filter

import models.image.GrayscaleImage

/**
 * Brightens or darkens a grayscale image
 * @param value integer that gets added to the current pixel values
 */
class BrightnessFilter(value : Int) extends GrayscaleImageFilter {
  /**
   * Brightens or darkens the image depending on the value in the constructor
   * @param grayscaleImage image that we brighten or darken
   * @return brightened or darkened image
   */
  override def apply(grayscaleImage: GrayscaleImage): GrayscaleImage = {
    val grayscalePixels = grayscaleImage.getData

    val brightenedPixels = grayscalePixels.map { row =>
      row.map { pixel =>
        var newPixel = pixel + value
        if (newPixel < 0){
          newPixel = 0
        }
        if (newPixel > 255) {
          newPixel = 255
        }
        newPixel
      }
    }

    new GrayscaleImage(brightenedPixels)
  }
}
