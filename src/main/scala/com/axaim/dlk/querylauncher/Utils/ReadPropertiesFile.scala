package com.axaim.dlk.querylauncher.Utils

import com.typesafe.config.{Config, ConfigFactory}

object ReadPropertiesFile {

  def getConfig(propertiesFileName : String) : Config = {

    //ConfigFactory.parseFile(getClass.getClassLoader.getResource("application.properties")

    val conf = ConfigFactory.load(propertiesFileName)
    conf
  }

}
