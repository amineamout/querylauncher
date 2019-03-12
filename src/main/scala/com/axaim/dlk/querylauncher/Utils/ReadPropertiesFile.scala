package com.axaim.dlk.querylauncher.Utils

import com.typesafe.config.{Config, ConfigFactory}

object ReadPropertiesFile {

  def getConfig(propertiesFileName : String) : Config = {

    //ConfigFactory.parseFile(getClass.getClassLoader.getResource("application.properties")

    /*
    val myConfigFile = new File("path/to/myconfig.conf")
    val fileConfig = ConfigFactory.parseFile(myConfigFile).getConfig("myconfig")
    val config = ConfigFactory.load(fileConfig)
     */

    val conf = ConfigFactory.load(propertiesFileName)
    conf
  }

}
