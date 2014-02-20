import play.Project._

name := """PlayFrameworkRecruitConsoleBase"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // Select Play modules
  javaJdbc,  // Java database API
  javaEbean, // Java Ebean plugin
  //javaJpa,   // Java JPA plugin
  javaCore,  // The core Java API
  cache,
	"org.webjars" %% "webjars-play" % "2.2.0",
	"org.webjars" % "bootstrap" % "3.1.1",
  	"org.webjars" % "font-awesome" % "4.0.3",
  "mysql" % "mysql-connector-java" % "5.1.29",
  "org.avaje.ebeanorm" % "avaje-ebeanorm-api" % "3.1.1")

playJavaSettings