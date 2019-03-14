package com.axaim.dlk.querylauncher.Utils

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{ monotonically_increasing_id, broadcast, col, lit}

class DataFrameCopyAppend(implicit spark : SparkSession) extends Serializable {


  def copyDataframeSchemaFull(histoDataframe : DataFrame, newDataFrame : DataFrame) : DataFrame = {

    val exprs = newDataFrame.schema.fields.map { colField =>
      if (histoDataframe.schema.fields.contains(colField)) histoDataframe.col(colField.name)
      else  newDataFrame.col(colField.name)
    }

    val histodf = histoDataframe.withColumn("generatedId1", monotonically_increasing_id())
    val newdf = newDataFrame.withColumn("generatedId2", monotonically_increasing_id())

    val resultDF = histodf.join(broadcast(newdf), histodf("generatedId1") === newdf("generatedId2"), "inner").select(exprs : _*)

    resultDF

  }

  def copyDataframeSchemaNull(histoDataframe : DataFrame, newDataFrame : DataFrame) : DataFrame = {

    val exprs = newDataFrame.schema.fields.map { colField =>
      if (histoDataframe.schema.fields.contains(colField)) col(colField.name)
      else lit(null).cast(colField.dataType).alias(colField.name)
    }

    histoDataframe.select(exprs: _*)

  }

  def appendDataframes(histoDataframe : DataFrame, newDataFrame : DataFrame, mode : String) : DataFrame = {

    mode match {
      case "append_full" => this.copyDataframeSchemaFull(histoDataframe, newDataFrame)
      case "append_null" => this.copyDataframeSchemaNull(histoDataframe, newDataFrame).union(newDataFrame)
    }



  }



}
