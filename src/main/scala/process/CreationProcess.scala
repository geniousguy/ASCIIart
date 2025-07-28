package process

import models.image.GrayscaleImage
import modules.converter.ascii_to_string.AsciiToString
import modules.converter.grayscale_to_ascii.GrayscaleToAscii
import modules.converter.pixel_image_to_grayscale.PixelImageToGrayscale
import modules.creator.image_creator.ImageCreator
import modules.exporter.string_exporter.StringExporter
import modules.filter.grayscale_image_filter.GrayscaleImageFilter

/**
 * A class that is designated for combining all the steps of image creation, makes use of polymorphism
 * @param imageCreator creator that will create the RGB pixel image
 * @param filters list of filters that will be applied
 * @param toAsciiConverter converter that will convert the image to ascii
 * @param exporters list of exporters that will export the image somewhere
 */
class CreationProcess(imageCreator: ImageCreator,
                      filters: List[GrayscaleImageFilter],
                      toAsciiConverter: GrayscaleToAscii,
                      exporters: List[StringExporter]
                     ) {

  /**
   * Creates ascii art and exports it 
   */
  def executeCreation(): Unit = {
    val pixelImage = imageCreator.create()
    val grayscaleImage = PixelImageToGrayscale().convert(pixelImage)
    val grayscaleImageAfterFilters = applyFilters(grayscaleImage)
    val asciiImage = toAsciiConverter.convert(grayscaleImageAfterFilters)
    val asciiString = AsciiToString().convert(asciiImage)
    
    exporters.foreach(stringExporter => stringExporter.doExport(asciiString))

  }

  /**
   * Applies filters from the constructor in the inputted order on a grayscale image
   * @param image image to apply the filters on
   * @return image with applied filters
   */
  private def applyFilters(image: GrayscaleImage) : GrayscaleImage = {
    var newImage = image
    filters.foreach(imageFilter => newImage = imageFilter.apply(newImage) )
    newImage
  }

  
}
