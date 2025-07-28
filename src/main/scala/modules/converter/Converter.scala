package modules.converter

/**
 * Converts something to something
 * @tparam T value to convert
 * @tparam U value T after conversion
 */
trait Converter [T, U] {
  def convert(input : T) : U
}
