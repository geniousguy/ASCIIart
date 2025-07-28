package modules.creator.image_creator

import models.image.PixelImage
import modules.creator.Creator

/**
 * Creates a PixelImage
 */
trait ImageCreator extends Creator[PixelImage] {

  /**
   * Creates a new image object (`Image`) from the given input data.
   *
   * @return The created image.
   */
  override def create(): PixelImage
}
