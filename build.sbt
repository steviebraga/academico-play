name := """academico"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.postgresql" % "postgresql" % "9.4-1204-jdbc42",
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "bootstrap" % "3.3.5",
  "org.webjars" % "bootstrapvalidator" % "0.5.3",
  "org.webjars" % "metisMenu" % "1.1.2",
  "org.webjars" % "font-awesome" % "4.2.0"
)
