package com.axaim.dlk.querylauncher.main

import com.axaim.dlk.querylauncher.Utils.LogHolder

class QueryLauncher extends App {

  LogHolder.log.info("starting app ...")


  val options = args(0)
  val tables = args(1).split(",")

  options match {
    case "-t" | "--table" => println("create table")
    case _ => println("mis usage of command line")
  }

}
