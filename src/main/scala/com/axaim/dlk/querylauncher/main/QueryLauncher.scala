package com.axaim.dlk.querylauncher.main

import com.axaim.dlk.querylauncher.Utils.{LogHolder, SparkQueryRun}
import org.apache.spark.sql.SparkSession

class QueryLauncher extends App {

  LogHolder.log.info("starting app ...")

  implicit val spark = SparkSession
                        .builder()
                        //important // .config("spark.sql.warehouse.dir", "user/hive/warehouse")
                      // .config("hive.metastore.uris","thrift://localhost:9083")
                        //.enableHiveSupport()
                        .getOrCreate()

  val sparkQueryRun = new SparkQueryRun()

  val options = args(0)
  val tables = args(1).split(",")
  val columns = args(2)
  val output = args(3)

  //"col1:val1,col2:val2"
  val columnsMap = columns.split(",").map(_.split(":")).map { case Array(k, v) => (k, v)}.toMap



  options match {
    case "-t" | "--table" => tables.foreach {
                              table =>

                                val df = sparkQueryRun.createDataframeFromQuery("select * from "+table)
                                val dfAddedCols = sparkQueryRun.addColumns(df, columnsMap)
                                sparkQueryRun.writeTable(dfAddedCols, output.toString)

                            }
    case _ => println("mis usage of command line")
  }

}
