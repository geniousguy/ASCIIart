package modules.creator.image_creator.image_loader

import models.image.{Pixel, PixelImage}
import modules.creator.image_creator.ImageCreator

import java.io.File
import javax.imageio.ImageIO

/**
 * An abstract class that provides a foundation for loading images.
 * @param filePath The path to the image file on the disk.
 *
 */
abstract class ImageLoader(filePath : String) extends ImageCreator{
  /**
   * Loads an image from the specified file path and converts it into an Image class.
   *
   * @return The loaded `Image` object.
   * @throws Exception If there's an error loading the image file.
   */
  override def create(): PixelImage = {
    try 
    {
      val file = new File(filePath)
      val bufferedImage = ImageIO.read(file)
      val width = bufferedImage.getWidth
      val height = bufferedImage.getHeight
      val pixels = Array.ofDim[Pixel](width, height)
      for (x <- 0 until width; y <- 0 until height) {
        val rgb = bufferedImage.getRGB(x, y)
        pixels(x)(y) = new Pixel(rgb)
      }
      new PixelImage(pixels)
    } 
    catch 
    {
      case e: Exception =>
        throw new Exception(s"Error loading image: ${e.getMessage}")
    }
  }

}
