package com.axaim.dlk.querylauncher

import com.axaim.dlk.querylauncher.Utils.SparkQueryRun
import com.axaim.dlk.querylauncher.utils.SparkUtils
import org.scalatest.{FunSpec, GivenWhenThen}

class SparkQueryRun$Test extends FunSpec with GivenWhenThen with SparkUtils {

  val sparkQuery = new SparkQueryRun

  describe("Create a dataframe from query") {

    it("should create a dataframe from a query string") {

      Given("a query string and a stored table")
      val query = "select * from people"
      val df = spark.createDataFrame(Seq(("amine", "axa", "im"), ("eric", "axa", "partners"), ("alex", "axa", "corporate"), ("houssam", "axa", "im"))).toDF()
      df.write.saveAsTable("people")

      When("calling createDataframeFromQuery")
      val dfFromQuery = sparkQuery.createDataframeFromQuery(query)

      Then("we have our dataframe shown")
      dfFromQuery.show()

    }
  }

  describe("Add columns to a dataframe") {

    it("should add columns taken in parameter to a dataframe") {

      Given("a dataframe and a list of columns")
      val colNames = Seq("age", "city", "job")
      val df = spark.createDataFrame(Seq(("amine", "axa", "im"), ("eric", "axa", "partners"), ("alex", "axa", "corporate"), ("houssam", "axa", "im"))).toDF()


      When("adding the columns and values")
      val dfAfterAddingColumns =  sparkQuery.addColumns(df, colNames)

      Then("the new dataframe is now")
      dfAfterAddingColumns.show()

    }
  }

}
