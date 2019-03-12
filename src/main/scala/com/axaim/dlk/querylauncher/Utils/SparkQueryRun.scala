package com.axaim.dlk.querylauncher.Utils

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{lit}

class SparkQueryRun(implicit spark : SparkSession) extends Serializable {



  def createDataframeFromQuery(query : String) : DataFrame = {

    val df = spark.sql(query)
    df
  }


  def addColumns(df : DataFrame, colVal : Map[String, String]) : DataFrame = {
    colVal.foldLeft(df){ case (df, (kColname, vColval)) => df.withColumn(kColname, lit(vColval))}
  }

  def addColumns(df : DataFrame, colNames : Seq[String]) : DataFrame = {

    colNames.foldLeft(df)((df, c) =>
      df.withColumn(c,  lit("a value"))
    )
  }


  def writeTable(df : DataFrame, outputPath : String) = {
    df.coalesce(1).write.csv(outputPath)
  }
}
