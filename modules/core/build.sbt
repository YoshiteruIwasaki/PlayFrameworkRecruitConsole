name := """core"""

version := "1.2"

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
