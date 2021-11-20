name := "gw2-scala"

version := "0.1"

scalaVersion := "2.13.7"

scalafmtOnCompile   := true
scalafmtCheck       := true
scalafmtSbtCheck    := true
autoCompilerPlugins := true

ThisBuild / organization := "bar.simon"

ThisBuild / Test / fork               := true
ThisBuild / Test / testForkedParallel := true

lazy val root = Project(id = "gw2-scala", base = file("."))
  .aggregate(domain, utils)

lazy val utils = Project(id = "utils", base = file("utils"))

lazy val domainBase = file("domain")

lazy val domain = Project(id = "domain", base = domainBase)
  .aggregate(gw2Domain)

lazy val gw2Domain = Project(id = "gw2-domain", base = domainBase / "gw2")
  .dependsOn(utils)
  .settings(
    libraryDependencies ++= Seq(
      "eu.timepit" %% "refined" % "0.9.27"
    )
  )
