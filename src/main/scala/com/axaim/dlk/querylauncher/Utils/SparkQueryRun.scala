package com.axaim.dlk.querylauncher.Utils

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{lit}

class SparkQueryRun(implicit spark : SparkSession) extends Serializable {



  def createDataframeFromQuery(query : String) : DataFrame = {

    val df = spark.sql(query)

    df
  }

  //should transform colNames to a map (with key value)
  def addColumns(df : DataFrame, colNames : Seq[String]) : DataFrame = {

    colNames.foldLeft(df)((df, c) =>
      df.withColumn(s"$c",  lit("a value"))
    )
  }


  def writeTable(df : DataFrame, outputPath : String) = {
    df.write.csv(outputPath)
  }
}
