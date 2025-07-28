package modules.converter.ascii_to_string

import models.image.AsciiImage
import modules.converter.Converter

/**
 * Converts an AsciiImage to a string
 */
class AsciiToString extends Converter[AsciiImage, String]{
  /**
   * Converts asciiImage to a string
   * @param asciiImage image made out of Ascii characters
   * @return asciiImage as a String
   */
  override def convert(asciiImage: AsciiImage): String = {
    val (pixels, width, height) = asciiImage.getDimensionsAndData
    val asciiArt = new StringBuilder
    for (y <- 0 until height) {
      for (x <- 0 until width) {
        asciiArt.append(pixels(x)(y))
      }
      asciiArt.append('\n')
    }
    asciiArt.toString()
  }
}
