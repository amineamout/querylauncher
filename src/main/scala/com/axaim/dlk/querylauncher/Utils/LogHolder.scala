package com.axaim.dlk.querylauncher.Utils

import org.apache.log4j.Logger

object LogHolder extends Serializable {

  @transient lazy val log = Logger.getLogger(getClass.getName)

}
