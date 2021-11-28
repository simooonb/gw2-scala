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
  .aggregate(gw2Domain, gw2HttpClient, utils)

lazy val utils = Project(id = "utils", base = file("utils"))

lazy val domainBase = file("domain")

lazy val gw2Domain = Project(id = "gw2-domain", base = file("gw2-domain"))
  .dependsOn(utils)
  .settings(
    libraryDependencies ++= Seq(
      "eu.timepit" %% "refined" % "0.9.27"
    )
  )

lazy val gw2HttpClient = Project(id = "gw2-http-client", base = file("gw2-http-client"))
  .dependsOn(gw2Domain)
  .settings(
    libraryDependencies ++= Seq(
      "eu.timepit"    %% "refined"              % "0.9.27",
      "org.typelevel" %% "cats-core"            % "2.6.1",
      "org.typelevel" %% "cats-effect"          % "3.2.9",
      "io.circe"      %% "circe-core"           % "0.14.1",
      "io.circe"      %% "circe-generic"        % "0.14.1",
      "io.circe"      %% "circe-refined"        % "0.14.1",
      "io.circe"      %% "circe-generic-extras" % "0.14.1",
      "io.circe"      %% "circe-parser"         % "0.14.1",
      "com.lihaoyi"   %% "requests"             % "0.6.9"
    )
  )
  .settings(
    libraryDependencies ++= Seq(
      "org.scalacheck"    %% "scalacheck"              % "1.15.4",
      "eu.timepit"        %% "refined-scalacheck"      % "0.9.27",
      "org.scalatest"     %% "scalatest"               % "3.2.10",
      "org.mockito"        % "mockito-core"            % "4.1.0",
      "org.scalatestplus" %% "mockito-1-10"            % "3.1.0.0",
      "org.mockito"       %% "mockito-scala-scalatest" % "1.16.46",
      "org.mockito"       %% "mockito-scala-cats"      % "1.16.46"
    ).map(_ % Test)
  )
