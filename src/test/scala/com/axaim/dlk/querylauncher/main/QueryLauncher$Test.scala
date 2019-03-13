package com.axaim.dlk.querylauncher.main

import java.io.File

import com.axaim.dlk.querylauncher.utils.SparkUtils$Test
import org.scalatest.{FunSpec, GivenWhenThen}

class QueryLauncher$Test extends FunSpec with GivenWhenThen with SparkUtils$Test {

  val ql = new QueryLauncher



  describe("Running the main class with args") {

    it("Run the main class to test the whole process") {

      Given("an args of elements")
      val args = Array("-t", "people", "date:13-03-2019,timestamp:113213032219", "output.csv")
      val df = spark.createDataFrame(Seq(("amine", "axa", "im"), ("eric", "axa", "partners"), ("alex", "axa", "corporate"), ("houssam", "axa", "im"))).toDF()
      spark.sql("drop table if exists people")
      val repo = "/home/dev/IdeaProjects/queryLauncher/spark-warehouse/"
      import org.apache.commons.io.FileUtils
      FileUtils.deleteDirectory(new File(repo))
      df.coalesce(1).write.saveAsTable("people")

      When("running the main class")
      ql.main(args)

      Then("the output file is created")


    }
  }

}
