ThisBuild / versionScheme := Some("early-semver")
ThisBuild / scalaVersion := "3.2.0"
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

val commonSettings = Seq(
  scalacOptions-="-Xsource:3.1",
  //scalacOptions -="-Xfatal-warnings"
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.4.8",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7",
    //"org.typelevel" %% "cats-mtl" % "1.3.0"
  )
)
lazy val shared = project.settings(commonSettings)

lazy val server = project.settings(commonSettings).dependsOn(shared)

lazy val client = project.settings(commonSettings).dependsOn(shared)

lazy val root = (project in file("."))
  .settings(
    name := "MiniDocker",
    publish := {},
    publish / skip := true
  )
  .aggregate(server,client,shared)
