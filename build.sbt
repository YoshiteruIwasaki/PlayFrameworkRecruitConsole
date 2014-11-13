import play.twirl.sbt.Import._

name := """PlayFrameworkRecruitConsole"""

version := "1.1"

lazy val main = (project in file(".")).enablePlugins(PlayJava)
    .dependsOn(common, base, core).aggregate(common, base, core)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  // Select Play modules
  javaJdbc,  // Java database API
  javaEbean, // Java Ebean plugin
  javaJpa,   // Java JPA plugin
  javaCore,  // The core Java API
  filters,
  cache,
  javaWs,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "select2" % "3.4.5",
  "mysql" % "mysql-connector-java" % "5.1.29",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
  "commons-codec" % "commons-codec" % "1.9",
  "net.sourceforge.nekohtml" % "nekohtml" % "1.9.20",
  "org.codehaus.jackson" % "jackson-jaxrs" % "1.9.13",
  "commons-validator" % "commons-validator" % "1.4.0",
  "commons-beanutils" % "commons-beanutils" % "1.9.1"
  )

//lazy val common = RootProject(file("modules/common"))

lazy val common = (project in file("modules/common")).enablePlugins(PlayJava)

lazy val base = (project in file("modules/base")).enablePlugins(PlayJava).dependsOn(common).aggregate(common)

lazy val core = (project in file("modules/core")).enablePlugins(PlayJava).dependsOn(common, base).aggregate(common, base)


TwirlKeys.templateImports += "_root_.views.html.base.helper._"

TwirlKeys.templateImports += "_root_.views.html.helper._"

TwirlKeys.templateImports += "utils._"