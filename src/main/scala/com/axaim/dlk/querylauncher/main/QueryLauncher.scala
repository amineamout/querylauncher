package com.axaim.dlk.querylauncher.main

import com.axaim.dlk.querylauncher.Utils.{LogHolder, SparkQueryRun}
import org.apache.spark.sql.SparkSession

class QueryLauncher extends App {

  LogHolder.log.info("starting app ...")

  implicit val spark = SparkSession
                        .builder()
                        .getOrCreate()

  val sparkQueryRun = new SparkQueryRun()

  val options = args(0)
  val tables = args(1).split(",")
  val columns = args(2)
  val output = args(3)

  val columnsMap = columns.substring(1, columns.length - 1)
    .split(",")
    .map(_.split(":"))
    .map { case Array(k, v) => (k.substring(1, k.length-1), v.substring(1, v.length-1))}
    .toMap

  tables.foreach {
    table =>

      val df = sparkQueryRun.createDataframeFromQuery("select * from "+table)
      val dfAddedCols = sparkQueryRun.addColumns(df, columnsMap)
      sparkQueryRun.writeTable(dfAddedCols, output.toString)

  }

  options match {
    case "-t" | "--table" => println("create table")
    case _ => println("mis usage of command line")
  }

}
