package ui.extractor


/**
 * Extracts T from a list of arguments
 * @tparam T value to extract
 */
trait Extractor[T] {
  /**
   * Extracts T from a list of arguments
   * @param arguments list of arguments as strings
   * @return (extracted value, arguments with or without the extracted arguments)
   */
  def extract(arguments: List[String]) : (T, List[String])

  /**
   * Function for checking if the next value is out of bounds. Used when we need to check an argument of an argument.
   * @param index index of the next value
   * @param arrayLength length of the array that we are checking in
   * @throws IllegalArgumentException if the next value doesn't exist
   */
  protected def checkOutOfBounds(index : Int, arrayLength: Int) : Unit = {
    if(index > arrayLength - 1){
      throw IllegalArgumentException("An argument wasn't specified")
    }
  }
}