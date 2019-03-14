package com.axaim.dlk.querylauncher

import com.axaim.dlk.querylauncher.Utils.DataFrameCopyAppend
import com.axaim.dlk.querylauncher.utils.SparkUtils$Test
import org.scalatest.{FunSpec, GivenWhenThen}

class DataFrameCopyAppend$Test extends FunSpec with GivenWhenThen with SparkUtils$Test {

  val dfCopyAppend = new DataFrameCopyAppend

  describe("Copy the dataframe and the values to an existing dataframe") {

    it("should take the schema and the values from a new dataframe to a histo dataframe that already exists by appending the data") {

      Given("a histo dataframe and a new dataframe")
      val histoDF = spark.createDataFrame(Seq(("amine", "axa", "im"), ("eric", "axa", "partners"), ("alex", "axa", "corporate"), ("houssam", "axa", "im"),("","",""))).toDF("name", "corp", "service")
      val newDF = spark.createDataFrame(Seq(("amine", "axa", "im", "1990"), ("eric", "axa", "partners", "1989"), ("alex", "axa", "corporate", "1995"), ("houssam", "axa", "im", "1993"), ("max", "axa", "im", "1993"))).toDF("name", "corp", "service", "someyear")

      When("calling the copy append schema function")
      val resultDF = dfCopyAppend.copyDataframeSchema(histoDF, newDF)


      Then("we get a new dataframe")
      resultDF.show()


    }
  }

}
