package modules.converter.grayscale_to_ascii

import models.image.{AsciiImage, GrayscaleImage}

/**
 * Converts grayscale to ASCII using linear transformation method
 */
class LinearTransformationTable extends GrayscaleToAscii {

  /**
   * Uses a pre defined transformation table
   * @param grayscaleImage image to convert
   * @return AsciiImage after conversion
   */
  override def convert(grayscaleImage: GrayscaleImage): AsciiImage = {
    convert(grayscaleImage, transformationTable)
  }

  /**
   * Uses a user defined transformation table
   * @param grayscaleImage image to convert
   * @param inputTransformationTable user defined transformationTable
   * @return AsciiImage after conversion
   */
  def convert(grayscaleImage: GrayscaleImage, inputTransformationTable : String) : AsciiImage = {
    val (pixels, width, height) = grayscaleImage.getDimensionsAndData
    val characterArray = Array.ofDim[Char](width, height)

    for (x <- 0 until width; y <- 0 until height) {
      val grayscaleValue = pixels(x)(y)
      characterArray(x)(y) = inputTransformationTable.charAt(calculateLinearTableIndex(grayscaleValue, inputTransformationTable))

    }

    new AsciiImage(characterArray)

  }

}
