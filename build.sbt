name := "queryLauncher"

version := "0.1"

scalaVersion := "2.12.8"

organization := "com.axaim"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.2"

//https://github.com/vegas-viz/Vegas

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}