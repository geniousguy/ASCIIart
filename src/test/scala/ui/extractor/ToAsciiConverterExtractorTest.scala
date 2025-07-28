package ui.extractor

import modules.converter.grayscale_to_ascii.{LinearTransformationTable, LinearTransformationTableWithArgs, NonLinearTransformationTable}
import org.scalatest.funsuite.AnyFunSuite

class ToAsciiConverterExtractorTest extends AnyFunSuite{
  val extractor = new ToAsciiConverterExtractor

  test("ToAsciiConverterExtractor should extract LinearTransformationTable when --table is specified") {
    val arguments = List("--table", "linear")
    val (converter, remainingArguments) = extractor.extract(arguments)

    assert(converter.isInstanceOf[LinearTransformationTable])
    assert(remainingArguments.isEmpty)
  }

  test("ToAsciiConverterExtractor should extract NonLinearTransformationTable when --table is specified") {
    val arguments = List("--table", "non-linear")
    val (converter, remainingArguments) = extractor.extract(arguments)

    assert(converter.isInstanceOf[NonLinearTransformationTable])
    assert(remainingArguments.isEmpty)
  }

  test("ToAsciiConverterExtractor should extract LinearTransformationTableWithArgs when --custom-table is specified") {
    val arguments = List("--custom-table")
    val (converter, remainingArguments) = extractor.extract(arguments)

    assert(converter.isInstanceOf[LinearTransformationTableWithArgs])
    assert(remainingArguments.isEmpty)
  }

  test("ToAsciiConverterExtractor should throw IllegalArgumentException when invalid table argument is specified") {
    val arguments = List("--table", "invalid")
    assertThrows[IllegalArgumentException](extractor.extract(arguments))
  }

  test("ToAsciiConverterExtractor should throw IllegalArgumentException when both --table and --custom-table are specified") {
    val arguments = List("--table", "linear", "--custom-table", "custom_table")
    assertThrows[IllegalArgumentException](extractor.extract(arguments))
  }

  test("ToAsciiConverterExtractor should extract LinearTransformationTable when no table argument is specified") {
    val arguments = List()
    val (converter, remainingArguments) = extractor.extract(arguments)

    assert(converter.isInstanceOf[LinearTransformationTable])
    assert(remainingArguments.isEmpty)
  }
}
