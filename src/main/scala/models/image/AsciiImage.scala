package models.image

/**
 * Image composed of ascii characters
 *
 * @param data 2D array of ascii characters
 */
class AsciiImage(data: Array[Array[Char]]) extends Image[Char](data, data.length, data.head.length) {
}
