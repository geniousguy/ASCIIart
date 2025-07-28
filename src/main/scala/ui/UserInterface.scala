package ui

import process.CreationProcess
import ui.extractor.{ExporterExtractor, GrayscaleImageFilterExtractor, ImageCreatorExtractor, ToAsciiConverterExtractor}

/**
 * Class that is responsible for user experience
 */
class UserInterface {
  /**
   * Parses the arguments and either gives user the image or tels him what went wrong
   * @param arguments user input
   */
  def run(arguments: List[String]): Unit = {
    try{
      val (imageCreator, argumentsAfterImageExtraction) = ImageCreatorExtractor().extract(arguments)
      val (toAsciiConverter, argumentsAfterConverterExtraction) = ToAsciiConverterExtractor().extract(argumentsAfterImageExtraction)
      val (exporters, argumentsAfterExporterExtraction) = ExporterExtractor().extract(argumentsAfterConverterExtraction)
      val filters = GrayscaleImageFilterExtractor().extract(argumentsAfterExporterExtraction)
      
      
      CreationProcess(imageCreator, filters._1, toAsciiConverter, exporters).executeCreation()

    }catch
      case e: Exception =>
        println(e.getMessage)
  }
}
