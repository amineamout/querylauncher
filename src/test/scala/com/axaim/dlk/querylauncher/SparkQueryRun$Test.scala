package com.axaim.dlk.querylauncher

import java.io.File
import java.sql.Date

import com.axaim.dlk.querylauncher.Utils.SparkQueryRun
import com.axaim.dlk.querylauncher.utils.SparkUtils$Test
import org.scalatest.{FunSpec, GivenWhenThen}

class SparkQueryRun$Test extends FunSpec with GivenWhenThen with SparkUtils$Test {

  val sparkQuery = new SparkQueryRun

  describe("Create a dataframe from query") {

    it("should create a dataframe from a query string") {

      Given("a query string and a stored table")
      val query = "select * from SparkQueryRunTest"
      val df = spark.createDataFrame(Seq(("amine", "axa", "im"), ("eric", "axa", "partners"), ("alex", "axa", "corporate"), ("houssam", "axa", "im"))).toDF()
      spark.sql("drop table if exists people")
      val currentDirectory = new java.io.File(".").getCanonicalPath
      val repo = currentDirectory+"/queryLauncher/spark-warehouse/"
      import org.apache.commons.io.FileUtils
      FileUtils.deleteDirectory(new File(repo))
      df.coalesce(1).write.saveAsTable("SparkQueryRunTest")

      When("calling createDataframeFromQuery")
      val dfFromQuery = sparkQuery.createDataframeFromQuery(query)

      Then("we have our dataframe shown")
      dfFromQuery.show()

    }
  }

  describe("Add columns to a dataframe") {

    it("should add columns taken in parameter to a dataframe") {

      Given("a dataframe and a list of columns")
      val colNames = Map("date_transac" -> java.time.LocalDate.now.toString, "timestamp_transac" -> System.currentTimeMillis.toString)
      val df = spark.createDataFrame(Seq(("amine", "axa", "im"), ("eric", "axa", "partners"), ("alex", "axa", "corporate"), ("houssam", "axa", "im"))).toDF()

      When("adding the columns and values")
      val dfAfterAddingColumns =  sparkQuery.addColumns(df, colNames)

      Then("the new dataframe is now")
      dfAfterAddingColumns.show()

    }
  }

}
