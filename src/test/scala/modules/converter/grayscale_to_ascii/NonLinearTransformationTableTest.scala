package modules.converter.grayscale_to_ascii

import models.image.GrayscaleImage
import org.scalatest.funsuite.AnyFunSuite

class NonLinearTransformationTableTest extends AnyFunSuite{
  test("Non linear table diversifies chars well"){
    val grayscalePixels = Array.ofDim[Int](4, 4)
    val difference = 255 / NonLinearTransformationTable().getTransformationTable.length
    var grayscaleValue = difference
    for (y <- 0 until 4) {
      for(x <- 0 until 4){
        grayscalePixels(x)(y) = grayscaleValue
      }
      grayscaleValue = difference + grayscaleValue
    }
    val grayscaleImage = new GrayscaleImage(grayscalePixels)

    val asciiImage = NonLinearTransformationTable().convert(grayscaleImage)
    val transformationTable = NonLinearTransformationTable().getTransformationTable

    assert(asciiImage.getWidth == grayscaleImage.getWidth && asciiImage.getHeight == grayscaleImage.getHeight)

    val asciiPixels = asciiImage.getData
    assert(asciiPixels(0)(0) == transformationTable.charAt(transformationTable.length-1))
    assert(asciiPixels(0)(1) == transformationTable.charAt(1))
    assert(asciiPixels(0)(2) == transformationTable.charAt(2))
    assert(asciiPixels(0)(3) == transformationTable.charAt(3))


  }
}
