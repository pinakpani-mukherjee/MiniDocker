ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

val commonSettings = Seq(
  scalaVersion := "3.2.0",
  //scalacOptions -="-Xfatal-warnings"
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.4.8",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7",
    //"org.typelevel" %% "cats-mtl" % "1.3.0"
  )
)

lazy val server = project.settings(commonSettings)

lazy val client = project.settings(commonSettings)

lazy val root = (project in file("."))
  .settings(
    name := "MiniDocker",
    publish := {}
  )
  .aggregate(server,client)