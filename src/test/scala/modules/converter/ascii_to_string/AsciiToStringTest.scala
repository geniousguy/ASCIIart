package modules.converter.ascii_to_string

import models.image.AsciiImage
import modules.converter.ascii_to_string.AsciiToString
import org.scalatest.funsuite.AnyFunSuite

class AsciiToStringTest extends AnyFunSuite{

  test("Creates a valid string"){
    val asciiArray = Array.ofDim[Char](4, 4)
    for (x <- 0 until 4; y <- 0 until 4) {
      asciiArray(x)(y) = '4'
    }

    val asciiImageToConvert = AsciiImage(asciiArray)
    val asciiToStringConverter = new AsciiToString

    val convertedString = asciiToStringConverter.convert(asciiImageToConvert)
    assert(convertedString.charAt(0).equals('4'))
    assert(convertedString.length.equals(asciiImageToConvert.getHeight * (asciiImageToConvert.getWidth + 1) ))
  }
}
