import play.Project._

name := """PlayFrameworkRecruitBase"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // Select Play modules
  javaJdbc,  // Java database API
  javaEbean, // Java Ebean plugin
  javaJpa,   // Java JPA plugin
  javaCore,  // The core Java API
  filters,
  cache,
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.1.1",
  "org.webjars" % "font-awesome" % "4.0.3",
  "mysql" % "mysql-connector-java" % "5.1.29",
  "commons-codec" % "commons-codec" % "1.9",
  "net.sf.opencsv" % "opencsv" % "2.3",
  "org.codehaus.jackson" % "jackson-jaxrs" % "1.9.13",
  "commons-beanutils" % "commons-beanutils" % "1.9.1")

playJavaSettings