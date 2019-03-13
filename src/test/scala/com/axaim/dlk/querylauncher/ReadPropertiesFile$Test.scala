package com.axaim.dlk.querylauncher

import com.axaim.dlk.querylauncher.Utils.ReadPropertiesFile
import com.axaim.dlk.querylauncher.utils.SparkUtils$Test
import org.scalatest.{FunSpec, GivenWhenThen}

class ReadPropertiesFile$Test extends FunSpec with GivenWhenThen with SparkUtils$Test {

  describe("A configuration file as input") {

    it("should read its properties") {

      Given("a basic properties file")
      val aPropertiesFileName = "app/application.properties"

      When("reading this file & its properties")
      val confs = ReadPropertiesFile.getConfig(aPropertiesFileName)

      Then("the asserted values should match as following")
      println(confs.getString("query"))
      println(confs.getString("driver_memory"))

    }
  }

}
