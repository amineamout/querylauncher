package com.axaim.dlk.querylauncher.utils

import org.apache.spark.sql.SparkSession

trait SparkUtils {

  implicit val spark = SparkSession.builder
    .master("local[*]")
    .appName("queryLauncher")
    .getOrCreate()

}
