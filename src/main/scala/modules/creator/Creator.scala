package modules.creator

/**
 * Represents a generic creator interface that can create objects of type `T`.
 *
 * @tparam T The type of the created object.
 */
trait Creator[T] {

  /**
   * Creates a new object of type `U` from the given input data.
   *
   * @return The created object.
   */
  def create(): T
}