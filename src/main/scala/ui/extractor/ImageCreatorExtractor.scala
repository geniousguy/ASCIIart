package ui.extractor

import modules.creator.image_creator.ImageCreator
import modules.creator.image_creator.image_generator.PureRngImageGenerator
import modules.creator.image_creator.image_loader.{ImageLoader, JpgImageLoader, PngImageLoader}

class ImageCreatorExtractor extends Extractor[ImageCreator] {
  /**
   * Extracts an `ImageLoader` instance based on the specified image path.
   *
   * @param imagePath The image path.
   * @return An `ImageLoader` instance.
   * @throws IllegalArgumentException If the image path does not end with ".jpg" or ".png".
   */
  private def extractImageLoader(imagePath: String): ImageLoader = {
    if (imagePath.endsWith(".jpg")) {
      new JpgImageLoader(imagePath)
    }
    else if (imagePath.endsWith(".png")) {
      new PngImageLoader(imagePath)
    }
    else {
      throw IllegalArgumentException("Image path doesnt end with jpg or png")
    }
  }

  /**
   * Extracts an `ImageCreator` instance from a list of command-line arguments.
   *
   * @param arguments A list of command-line arguments.
   * @return A tuple containing the extracted `ImageCreator` and the remaining arguments.
   * @throws IllegalArgumentException If the arguments are invalid.
   */
  override def extract(arguments: List[String]): (ImageCreator, List[String]) = {
    if(arguments.contains("--image-random") && arguments.contains("--image") ){
      throw IllegalArgumentException("Only one image source must be specified")
    }
    if(arguments.count(value => value.equals("--image-random")) > 1 || arguments.count(value => value.equals("--image")) > 1){
      throw IllegalArgumentException("Only one image source must be specified")
    }
    
    
    if (arguments.contains("--image-random")) {
      (PureRngImageGenerator(), arguments.filter(value => value != "--image-random"))
    } else if (arguments.contains("--image")) {
      val nextIndex = arguments.indexOf("--image") + 1
      checkOutOfBounds(nextIndex, arguments.length)
      val imagePath = arguments(nextIndex)
      (extractImageLoader(imagePath), arguments.filter(value => value != "--image" && value != imagePath))
    } else {
      throw new IllegalArgumentException("No --image specified")
    }
  }
}
