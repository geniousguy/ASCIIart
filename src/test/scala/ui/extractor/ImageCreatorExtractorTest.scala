package ui.extractor

import modules.creator.image_creator.ImageCreator
import modules.creator.image_creator.image_generator.PureRngImageGenerator
import org.scalatest.funsuite.AnyFunSuite

class ImageCreatorExtractorTest extends AnyFunSuite{
  val extractor = new ImageCreatorExtractor

  test("ImageCreatorExtractor should extract a PureRngImageGenerator when --image-random is present") {
    val arguments = List("--image-random")
    val (imageCreator, remainingArguments) = extractor.extract(arguments)

    assert(imageCreator.isInstanceOf[PureRngImageGenerator])
    assert(remainingArguments.isEmpty)
  }

  test("ImageCreatorExtractor should extract an ImageLoader-based ImageCreator when --image is present") {
    val arguments = List("--image", "test.jpg")
    val (imageCreator, remainingArguments) = extractor.extract(arguments)

    assert(imageCreator.isInstanceOf[ImageCreator])
    assert(remainingArguments.isEmpty)
  }

  test("ImageCreatorExtractor should throw an IllegalArgumentException if both --image-random and --image are present") {
    val arguments = List("--image-random", "--image", "test.jpg")
    assertThrows[IllegalArgumentException](extractor.extract(arguments))
  }

  test("ImageCreatorExtractor should throw an IllegalArgumentException if --image is present without a path") {
    val arguments = List("--image")
    assertThrows[IllegalArgumentException](extractor.extract(arguments))
  }

  test("ImageCreatorExtractor should throw an IllegalArgumentException if the image path has an invalid extension") {
    val arguments = List("--image", "test.txt")
    assertThrows[IllegalArgumentException](extractor.extract(arguments))
  }
}
