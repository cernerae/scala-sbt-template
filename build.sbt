val props = SettingKey[Map[String,String]]("props")
val propertyFile = "build.properties"

props := {
  import scala.collection.JavaConversions._
  val properties = new java.util.Properties()
  IO.load(properties, baseDirectory.value / propertyFile )
  properties.stringPropertyNames.map (p =>
    p -> Option(System.getProperty(p)).getOrElse(properties.getProperty(p))).toMap
}

enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)

organization := props.value("project.organization")

name := props.value("project.name")

version := props.value("project.version")

scalaVersion := props.value("project.scala-version")

scalacOptions := Seq("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= Seq(

  "com.typesafe" % "config" % props.value("typesafe-config")

)

dockerRepository := Some(props.value("docker.organization"))

// Define the Dockerfile
dockerfile in docker := {
  val jarFile = artifactPath.in(Compile, packageBin).value
  val classpath = (managedClasspath in Compile).value
  val mainclass =  props.value("docker.main-class")
  val jarTarget = s"/app/${jarFile.getName}"
  // Make a colon separated classpath with the JAR file
  val classpathString = classpath.files.map("/app/" + _.getName).mkString(":") + ":" + jarTarget

  new Dockerfile {
    // Base image
    from(image = props.value("docker.base-image"))

    // Add all files on the classpath
    add(classpath.files, "/app/")

    // Add the JAR file
    add(jarFile, jarTarget)

    // On launch run Java with the classpath and the main class
    entryPoint("java", "-cp", classpathString, mainclass)

  }

}

