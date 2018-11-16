import org.ensime.EnsimeKeys._

name := "scala-starter-kit"

version := "0.1"

scalaVersion := "2.12.6"

val akkaVersion = "2.5.16"
val akkaHttpVersion = "10.1.5"
val sangriaVersion = "1.0.1"

ensimeIgnoreMissingDirectories := true
ensimeScalaVersion in ThisBuild := scalaVersion.value

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,

  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.5",
  "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test",

  "com.google.inject" % "guice" % "4.1.0",
  "net.codingwell" %% "scala-guice" % "4.2.1",

  "org.sangria-graphql" %% "sangria" % "1.4.2",
  "org.sangria-graphql" %% "sangria-spray-json" % sangriaVersion,
  "org.sangria-graphql" %% "sangria-akka-streams" % sangriaVersion,
  "org.sangria-graphql" %% "sangria-monix" % "1.0.0",

  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",

  "org.xerial" % "sqlite-jdbc" % "3.7.2",
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",

  "com.github.jurajburian" %% "mailer" % "1.2.3",
  "org.clapper" %% "classutil" % "1.3.0",

  "com.pauldijou" %% "jwt-core" % "0.19.0",

  "com.nulab-inc" %% "scala-oauth2-core" % "1.3.0"
)

parallelExecution in test := false
fork in Test := true
envVars in Test := Map("env" -> "test")