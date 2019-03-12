package com.axaim.dlk.querylauncher.Utils

import org.apache.spark.sql.SparkSession

class SparkUtils {

  implicit val spark = SparkSession.builder
    .master("local[*]")
    .appName("queryLauncher")
    .getOrCreate()

}
