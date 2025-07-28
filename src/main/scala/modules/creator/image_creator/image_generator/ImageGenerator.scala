package modules.creator.image_creator.image_generator

import models.image.PixelImage
import modules.creator.image_creator.ImageCreator

/**
 * An abstract class that provides a foundation for generating images.
 *
 */
abstract class ImageGenerator extends ImageCreator{
  /**
   * The minimum allowed dimension for the generated image.
   */
  protected val MIN_DIMENSION = 100
  /**
   * The maximum allowed dimension for the generated image.
   */
  protected val MAX_DIMENSION = 200
  
  def getMinDimension : Int = MIN_DIMENSION
  def getMaxDimension : Int = MAX_DIMENSION

  /**
   * Generates an image based on the specified dimensions.
   *
   * @return The generated image.
   */
  override def create(): PixelImage

}