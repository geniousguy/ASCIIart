package modules.exporter.string_exporter

/**
 * Export string to console
 */
class ToConsoleStringExporter extends StringExporter {
  /**
   * Export string to console
   * @param input string to export
   */
  override def doExport(input: String): Unit = {
    print(input)
  }
}
