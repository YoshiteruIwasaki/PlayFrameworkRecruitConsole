import play.twirl.sbt.Import._

name := """base"""

version := "1.2"

lazy val base = (project in file("modules/base")).enablePlugins(PlayJava).dependsOn(common).aggregate(common)

lazy val common = (project in file("modules/common")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

Common.settings

libraryDependencies ++= Common.coreDependency

libraryDependencies ++= Seq(
  // Select Play modules
  javaJdbc,  // Java database API
  javaEbean, // Java Ebean plugin
  javaJpa,   // Java JPA plugin
  javaCore,  // The core Java API
  filters,
  cache,
  javaWs)


TwirlKeys.templateImports += "utils.base.helper._"