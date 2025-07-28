package ui.extractor

import modules.converter.grayscale_to_ascii.{GrayscaleToAscii, LinearTransformationTable, LinearTransformationTableWithArgs, NonLinearTransformationTable}

class ToAsciiConverterExtractor extends Extractor[GrayscaleToAscii]{
  /**
   * Extracts a `GrayscaleToAscii` instance from a list of command-line arguments.
   *
   * @param arguments A list of command-line arguments.
   * @return A tuple containing the extracted `GrayscaleToAscii` and the remaining arguments.
   * @throws IllegalArgumentException If the arguments are invalid.
   */
  override def extract(arguments: List[String]): (GrayscaleToAscii, List[String]) = {
    if(arguments.contains("--table") && arguments.contains("--custom-table")){
      throw IllegalArgumentException("Only one table must be specified")
    }
    if(arguments.count(s => s.equals("table")) > 1 || arguments.count(s => s.equals("--custom-table")) > 1){
      throw IllegalArgumentException("Only one table must be specified")
    }
    
    
    val argumentArray = arguments.toArray
    if (argumentArray.contains("--table")) {
      val nextIndex = argumentArray.indexOf("--table") + 1
      checkOutOfBounds(nextIndex, argumentArray.length)
      val argument = argumentArray(nextIndex)
      argument match
        case "linear" =>
          (LinearTransformationTable(), arguments.filter(value => value != "--table" && value != argument))
        case "non-linear" =>
          (NonLinearTransformationTable(), arguments.filter(value => value != "--table" && value != argument))
        case _ =>
          throw IllegalArgumentException(s"Invalid filter option $argument")
    } else if (argumentArray.contains("--custom-table")) {
      val nextIndex = argumentArray.indexOf("--table") + 1
      checkOutOfBounds(nextIndex, argumentArray.length)
      val argument = argumentArray(nextIndex)
      (LinearTransformationTableWithArgs(argument), arguments.filter(value => value != "--custom-table" && value != argument))
    } else {
      (LinearTransformationTable(), arguments)
    }
  }
}
