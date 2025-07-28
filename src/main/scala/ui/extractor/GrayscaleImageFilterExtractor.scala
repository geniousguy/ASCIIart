package ui.extractor

import modules.filter.grayscale_image_filter.Axis.{XAXIS, YAXIS}
import modules.filter.grayscale_image_filter.{BrightnessFilter, FlipFilter, GrayscaleImageFilter, InvertFilter}

/**
 * Extracts grayscale image filters
 */
class GrayscaleImageFilterExtractor extends Extractor[List[GrayscaleImageFilter]]{

  /**
   * @param filterArguments list of ONLY filter arguments as strings
   * @return (list of filters to apply, arguments as they were inputted)
   */
  override def extract(filterArguments: List[String]): (List[GrayscaleImageFilter], List[String]) = {
    (extractFilters(filterArguments), filterArguments)
  }

  /**
   *
   * @param filterArguments list of ONLY filter arguments as strings
   * @return list of filters to apply
   * @throws IllegalArgumentException if there was a bad argument for a filter or the filter inputted doesn't exist
   */
  private def extractFilters(filterArguments: List[String]): List[GrayscaleImageFilter] = {
    var filterArray = Array[GrayscaleImageFilter]()
    val filterArgumentsArray = filterArguments.toArray
    var skipIteration = false

    for (x <- filterArgumentsArray.indices) {
      if (!skipIteration) {
        filterArgumentsArray(x) match
          case "--invert" =>
            filterArray = filterArray :+ InvertFilter()
          case "--flip" =>
            checkOutOfBounds(x+1, filterArgumentsArray.length)
            val argument = filterArgumentsArray(x + 1)
            if (argument.equals("x")) {
              filterArray = filterArray :+ FlipFilter(XAXIS)
              skipIteration = true
            } else if (argument.equals("y")) {
              filterArray = filterArray :+ FlipFilter(YAXIS)
              skipIteration = true
            } else {
              throw IllegalArgumentException(s"Bad argument for flip filter. Required: x or y Got: $argument")
            }
          case "--brightness" =>
            checkOutOfBounds(x+1, filterArgumentsArray.length)
            val argument = filterArgumentsArray(x + 1).toInt
            filterArray = filterArray :+ BrightnessFilter(argument)
            skipIteration = true
          case _ =>
            throw IllegalArgumentException(s"No such filter ${filterArgumentsArray(x)}")
      } else {
        skipIteration = false
      }
    }

    filterArray.toList
  }
}
