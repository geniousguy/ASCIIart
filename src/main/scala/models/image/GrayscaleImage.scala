package models.image

/**
 * Image composed of integers that each represent a grayscale pixel
 *
 * @param data 2D array of integers that each represent a grayscale pixel
 */
class GrayscaleImage(data: Array[Array[Int]]) extends Image[Int](data, data.length, data.head.length){

}
