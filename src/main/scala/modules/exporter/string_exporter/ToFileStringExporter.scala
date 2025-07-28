package modules.exporter.string_exporter

import java.io.{FileWriter, IOException}

/**
 * Export string to a file
 * @param filePath path to export the string to
 */
class ToFileStringExporter(filePath:String) extends StringExporter {
  /**
   * Export string to a filePath specified in the constructor
   * @param ascii string to export
   */
  override def doExport(ascii: String): Unit = {
    try {
      val writer = new FileWriter(filePath)
      writer.write(ascii)
      writer.close()
    } catch {
      case e: IOException =>
        throw new IOException(s"Error writing to or opening file: ${e.getMessage}")
    }
  }
}
