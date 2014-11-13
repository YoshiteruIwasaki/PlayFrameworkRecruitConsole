import play.twirl.sbt.Import._

name := """PlayFrameworkRecruitBase"""

version := "1.1"

lazy val base = (project in file(".")).enablePlugins(PlayJava)
    .dependsOn(common).aggregate(common)

lazy val common = (project in file("common")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

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