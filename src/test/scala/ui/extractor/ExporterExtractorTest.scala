package ui.extractor

import modules.exporter.string_exporter.{ToConsoleStringExporter, ToFileStringExporter}
import org.scalatest.funsuite.AnyFunSuite

class ExporterExtractorTest extends AnyFunSuite{
  val extractor = new ExporterExtractor

  test("Extracts to file exporter"){
    val arguments3 = List("--output-file", "output.txt")
    val (exporters3, remainingArguments3) = extractor.extract(arguments3)
    assert(exporters3.size == 1)
    assert(remainingArguments3.isEmpty)
  }

  test("Extracts to console exporter"){
    val arguments2 = List("--output-console")
    val (exporters2, remainingArguments2) = extractor.extract(arguments2)
    assert(exporters2.size == 1)
    assert(remainingArguments2.isEmpty)
  }

  test("Extracts to console exporter and to file exporter") {
    val arguments1 = List("--output-console", "--output-file", "output.txt")
    val (exporters1, remainingArguments1) = extractor.extract(arguments1)
    assert(exporters1.size == 2)
    assert(remainingArguments1.isEmpty)
  }

  test("ExporterExtractor should throw an IllegalArgumentException if no output is specified") {
    val arguments = List()
    assertThrows[IllegalArgumentException](extractor.extract(arguments))
  }
}
