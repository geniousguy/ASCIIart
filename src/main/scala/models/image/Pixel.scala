package models.image

/**
 * Image that represents a pixel
 * @param red color as an integer that has values 0-255
 * @param green color as an integer that has values 0-255
 * @param blue color as an integer that has values 0-255
 */
class Pixel(private val red: Int,private val green: Int,private val blue: Int) {
  def this(intRgb: Int) = this(
    (intRgb >> 16) & 0xFF,
    (intRgb >> 8) & 0xFF,
    intRgb & 0xFF
  )
  
  def getRed: Int = red
  def getGreen: Int = green
  def getBlue: Int = blue
  
  def this(pixel: Pixel) = this(
    pixel.red, pixel.green, pixel.blue
  )

  def equals(other : Pixel) : Boolean = {
    red == other.red && blue == other.blue && green == other.green
  }
}
