package ui.extractor

import modules.exporter.string_exporter.{StringExporter, ToConsoleStringExporter, ToFileStringExporter}

/**
 * Extracts a list of exporters
 */
class ExporterExtractor extends Extractor[List[StringExporter]]{

  /**
   * Extracts a list of exporters
   * @param arguments list of arguments as strings
   * @return (extracted value, arguments without the inputted filters)
   * @throws IllegalArgumentException if there was no output specified or there was no path argument for --output-file
   */
  override def extract(arguments: List[String]): (List[StringExporter], List[String]) = {
    var argumentArray = arguments.toArray
    var exporters = List[StringExporter]()

    if (!arguments.contains("--output-console") && !arguments.contains("--output-file")) {
      throw IllegalArgumentException("No output specified")
    }

    if (arguments.contains("--output-console")) {
      exporters = exporters :+ ToConsoleStringExporter()
      argumentArray = argumentArray.filter(value => value != "--output-console")
    }
    if (arguments.contains("--output-file")) {
      val nextIndex = arguments.indexOf("--output-file") + 1
      checkOutOfBounds(nextIndex, arguments.length)
      val argument = arguments(nextIndex)
      exporters = exporters :+ ToFileStringExporter(argument)
      argumentArray = argumentArray.filter(value => value != "--output-file" && value != argument)
    }

    (exporters, argumentArray.toList)
  }
}
