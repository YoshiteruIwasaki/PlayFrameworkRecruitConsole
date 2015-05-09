import play.twirl.sbt.Import._

name := """PlayFrameworkRecruitConsole"""

version := "1.2"

lazy val main = (project in file(".")).enablePlugins(PlayJava)
    .dependsOn(common, base, core).aggregate(common, base, core)

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
  javaWs,
  "org.webjars" % "select2" % "3.5.2"
  )

//lazy val common = RootProject(file("modules/common"))

lazy val core = (project in file("modules/core")).enablePlugins(PlayJava).dependsOn(common, base).aggregate(common, base)

lazy val base = (project in file("modules/base")).enablePlugins(PlayJava).dependsOn(common).aggregate(common)

//lazy val common = (project in file("modules/common")).enablePlugins(PlayJava)

lazy val common = (project in file("modules/common")).enablePlugins(SbtWeb)

TwirlKeys.templateImports += "_root_.views.html.base.helper._"

TwirlKeys.templateImports += "_root_.views.html.helper._"

TwirlKeys.templateImports += "utils._"