package modules.converter.grayscale_to_ascii

import models.image.GrayscaleImage
import org.scalatest.funsuite.AnyFunSuite

class LinearTransformationTableTest extends AnyFunSuite{
  private def testTransformationTable(isPreDefined: Boolean, transformationTable: String) = {
    val grayscalePixels = Array.ofDim[Int](4, 4)
    val difference = 255 / transformationTable.length
    var grayscaleValue = 0
    for (x <- 0 until 4; y <- 0 until 4) {
      grayscalePixels(x)(y) = grayscaleValue
      if(grayscaleValue > 255) grayscaleValue = 255
      grayscaleValue = grayscaleValue + difference
    }
    val grayscaleImage = new GrayscaleImage(grayscalePixels)


    val asciiImage = 
      if (isPreDefined)
      LinearTransformationTable().convert(grayscaleImage)
      else LinearTransformationTable().convert(grayscaleImage, transformationTable)


    assert(asciiImage.getWidth == grayscaleImage.getWidth && asciiImage.getHeight == grayscaleImage.getHeight)
    val asciiPixels = asciiImage.getData
    assert(asciiPixels(0)(0) == transformationTable.charAt(0))
    assert(asciiPixels(0)(1) == transformationTable.charAt(0))
    assert(asciiPixels(0)(2) == transformationTable.charAt(1))
    assert(asciiPixels(0)(3) == transformationTable.charAt(2))
  }

  test("Pre defined transformation table") {
    testTransformationTable(true, LinearTransformationTable().getTransformationTable)
  }

  test("User defined transformation table") {
    testTransformationTable(false, ".:)-.-")
  }
}
