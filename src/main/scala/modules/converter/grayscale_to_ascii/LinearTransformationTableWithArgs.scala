package modules.converter.grayscale_to_ascii

import models.image.{AsciiImage, GrayscaleImage}

/**
 * Converts a grayscaleImage to ascii based on a user inputted transformation table
 *
 * @param table user inputted transformation table
 */
class LinearTransformationTableWithArgs(table: String) extends LinearTransformationTable {
  /**
   * Converts a grayscaleImage to ascii based on the table in the constructor
   * @param grayscaleImage image to convert
   * @return AsciiImage after conversion
   */
  override def convert(grayscaleImage: GrayscaleImage): AsciiImage = super.convert(grayscaleImage, table)
}
