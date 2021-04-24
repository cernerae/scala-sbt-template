package com.sample

import com.typesafe.config.ConfigFactory

object MainSampleClass extends App {

  println("Hello World!")

  val config = ConfigFactory.load()
  println(s"x: ${config.getString("app.x")}")
  println(s"y: ${config.getString("app.y")}")

}
