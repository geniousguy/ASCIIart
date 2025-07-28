package modules.creator.image_creator.image_loader

import models.image.Pixel
import modules.creator.image_creator.image_loader.JpgImageLoader
import org.scalatest.funsuite.AnyFunSuite

class JpgImageLoaderTest extends AnyFunSuite
{
  test("Loading invalid path"){
    val invalidPath = "susPath"
    val thrown = intercept[Exception] {
      JpgImageLoader(invalidPath).create()
    }
  }

  test("Creation"){
      val image0 = JpgImageLoader("src/images/jpg_fire.jpg").create()
      assert(image0.getWidth == 612 )
      assert(image0.getHeight == 408)

      val pixel1 = new Pixel(1,1,1)
      assert(image0.getPixel(0,0).equals(pixel1))

      val pixel2 = new Pixel(255, 179, 8)
      assert(image0.getPixel(350,250).equals(pixel2))

      val pixel3 = new Pixel(255, 207, 0)
      assert(image0.getPixel(300,200).equals(pixel3))

  }

}
