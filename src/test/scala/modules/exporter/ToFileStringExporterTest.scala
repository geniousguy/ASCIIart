package modules.exporter

import modules.exporter.string_exporter.ToFileStringExporter
import org.scalatest.funsuite.AnyFunSuite

import java.io.{BufferedReader, File, FileReader, IOException}

class ToFileStringExporterTest extends AnyFunSuite{
  test("Should handle IOException") {
    val testString = "This is a test string"
    val invalidPath = ""
    val exporter = new ToFileStringExporter(invalidPath)


    val thrown = intercept[IOException] {
      exporter.doExport(testString)
    }
  }

  test("Should write a string to a file") {
    val testString = "This is a test string"
    val tempFile = File.createTempFile("test_export", ".txt")
    val exporter = new ToFileStringExporter(tempFile.getAbsolutePath)

    exporter.doExport(testString)

    val reader = new BufferedReader(new FileReader(tempFile))
    val fileContent = reader.readLine()
    reader.close()
    fileContent === testString

    tempFile.delete()
  }
}
