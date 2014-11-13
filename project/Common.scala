import sbt._
import Keys._

object Common {
  val settings: Seq[Setting[_]] = Seq(
  )

  val coreDependency = Seq(
    "org.webjars" %% "webjars-play" % "2.3.0",
    "mysql" % "mysql-connector-java" % "5.1.29",
    "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
    "commons-codec" % "commons-codec" % "1.9",
    "net.sourceforge.nekohtml" % "nekohtml" % "1.9.20",
    "org.codehaus.jackson" % "jackson-jaxrs" % "1.9.13",
    "commons-validator" % "commons-validator" % "1.4.0",
    "commons-beanutils" % "commons-beanutils" % "1.9.1")
}