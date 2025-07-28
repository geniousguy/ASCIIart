package modules.filter

/**
 * Trait for applying filters
 * @tparam T something on what we apply our filter
 * @tparam U something that comes out after applying the filter
 */
trait SomeFilter [T, U] {
  def apply(input : T) : U
}
