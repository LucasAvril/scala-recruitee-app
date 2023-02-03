val ScalatraVersion = "2.8.2"

ThisBuild / scalaVersion := "2.13.9"
ThisBuild / organization := "com.citreum"

lazy val hello = (project in file("."))
  .settings(
    name := "Scala Recruitee App",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % "2.12.6",
      "org.scala-native" %% "nir" % "0.4.9",
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.43.v20210629" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "org.kohsuke" % "github-api" % "1.302",
      "org.scalacheck" %% "scalacheck" % "1.14.3",
      "org.scalatest" %% "scalatest" % "3.1.2",
      "org.scalatestplus" %% "scalacheck-1-14" % "3.2.0.0",
      "io.circe" %% "circe-core" % "0.14.1",
      "io.circe" %% "circe-generic" % "0.14.1",
      "io.circe" %% "circe-parser" % "0.14.1",
      "com.typesafe.play" %% "play-json" % "2.9.4",
      "com.github.xuwei-k" %% "jwt-scala" % "1.8.1",
      "codes.reactive" %% "scala-time" % "0.4.2"
    )
  )

enablePlugins(SbtTwirl)
enablePlugins(JettyPlugin)
