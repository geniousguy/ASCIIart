package modules.creator.image_creator.image_generator

import modules.creator.image_creator.image_generator.PureRngImageGenerator
import org.scalatest.funsuite.AnyFunSuite

class PureRngImageGeneratorTest extends AnyFunSuite{

  test("An image was created"){
    val createdImage = PureRngImageGenerator().create()

    assert(createdImage.getHeight > 0)
    assert(createdImage.getWidth > 0)

    assert(!createdImage.pixelsAreEmpty)

  }
}
