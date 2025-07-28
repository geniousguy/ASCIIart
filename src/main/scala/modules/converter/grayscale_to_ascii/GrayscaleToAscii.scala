package modules.converter.grayscale_to_ascii

import models.image.{AsciiImage, GrayscaleImage}
import modules.converter.Converter

/**
 * Abstract class for conversion from GrayscaleImage to AsciiImage
 */
abstract class GrayscaleToAscii extends Converter[GrayscaleImage, AsciiImage]{
  /**
   * A default transformationTable to be used
   */
  protected val transformationTable = " .:-=+*#%@"
  
  def getTransformationTable: String = new String(transformationTable)

  /**
   * Calculates a position of a character based on its grayscale value in a transformationTable. 
   * Spreads the indexes evenly between each character. Eg: 0..25 grayscale values will map on the first character in a 10
   * char transformationTable
   * @param grayscaleValue grayscale value of a grayscale pixel 
   * @param transformationTable transformation table like " .:-=+*#%@" 
   * @return index of a character in the transformationTable
   */
  def calculateLinearTableIndex(grayscaleValue: Int, transformationTable: String) : Int = {
    grayscaleValue * (transformationTable.length - 1) / 255
  }
}
