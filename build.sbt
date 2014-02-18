
name := """PlayFrameworkRecruitConsole"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // Select Play modules
  //jdbc,      // The JDBC connection pool and the play.api.db API
  //anorm,     // Scala RDBMS Library
  javaJdbc,  // Java database API
  javaEbean, // Java Ebean plugin
  //javaJpa,   // Java JPA plugin
  //filters,   // A set of built-in filters
  javaCore,  // The core Java API
  // WebJars pull in client-side web libraries
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.1.1",
  "org.webjars" % "font-awesome" % "4.0.3",
  // Add your own project dependencies in the form:
  "mysql" % "mysql-connector-java" % "5.1.29"
  // "group" % "artifact" % "version"
)

play.Project.playScalaSettings
