package modules.converter.grayscale_to_ascii

import models.image.{AsciiImage, GrayscaleImage}

/**
 * Converts grayscale to ASCII using non-linear transformation method
 */
class NonLinearTransformationTable extends GrayscaleToAscii {

  /**
   * Converts using a method where if grayscale value < 50 we convert to the last character in the pre-defined
   * transformationTable, else we distribute the chars equally
   * @param grayscaleImage image to convert
   * @return AsciiImage after conversion
   */
  override def convert(grayscaleImage: GrayscaleImage): AsciiImage = {
    val (pixels, width, height) = grayscaleImage.getDimensionsAndData
    val characterArray = Array.ofDim[Char](width, height)

    for (x <- 0 until width; y <- 0 until height) {
      val grayscaleValue = pixels(x)(y)
      if(grayscaleValue < 50){
        characterArray(x)(y) = transformationTable.charAt(transformationTable.length - 1)
      } else{
        characterArray(x)(y) = transformationTable.charAt(calculateLinearTableIndex(grayscaleValue, transformationTable))
      }
    }

    new AsciiImage(characterArray)
  }

}
