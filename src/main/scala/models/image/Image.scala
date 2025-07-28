package models.image

import scala.reflect.ClassTag

/**
 * 
 * @param data 2D array of pixel values that the image is composed of
 * @param width width of the image
 * @param height height of the image
 * @param classTag$T$0 needed for compilation
 * @tparam T pixel
 */
abstract class Image[T : ClassTag](private val data: Array[Array[T]],private val width: Int,private val height: Int){
  def getWidth: Int = width

  def getHeight: Int = height

  def getData: Array[Array[T]] = {
    val copy = Array.ofDim[T](width, height)
    for (x <- 0 until width; y <- 0 until height) {
      copy(x)(y) = data(x)(y)
    }
    copy
  }

  /**
   * 
   * @return pixels, width, height
   */
  def getDimensionsAndData : (Array[Array[T]], Int, Int) = {
    (getData, getWidth, getHeight)
  }
}
