package process

import modules.converter.grayscale_to_ascii.LinearTransformationTable
import modules.creator.image_creator.image_generator.PureRngImageGenerator
import modules.exporter.string_exporter.ToConsoleStringExporter
import modules.filter.grayscale_image_filter.{BrightnessFilter, GrayscaleImageFilter, InvertFilter}
import org.scalatest.funsuite.AnyFunSuite

class CreationProcessTest extends AnyFunSuite {
  test("CreationProcess compiles") {
    val imageCreator = new PureRngImageGenerator
    val filters = List(new InvertFilter(), new BrightnessFilter(20))
    val toAsciiConverter = new LinearTransformationTable()
    val exporters = List(new ToConsoleStringExporter())

    val creationProcess = new CreationProcess(imageCreator, filters, toAsciiConverter, exporters)
  }


}
