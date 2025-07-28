package models.image

/**
 * Image composed of pixels
 * @param pixels 2D array of pixels
 */
class PixelImage(pixels: Array[Array[Pixel]]) extends Image[Pixel](pixels, pixels.length, pixels.head.length) {

  def getPixel(x : Int, y: Int) : Pixel = {
    if(x < 0 || y < 0 || x > getWidth || y > getHeight){
      throw new IllegalArgumentException(s"Pixel coordinates ($x, $y) are out of bounds.")
    }
    new Pixel(pixels(x)(y))
  }
  
  def pixelsAreEmpty : Boolean = pixels.isEmpty
}
