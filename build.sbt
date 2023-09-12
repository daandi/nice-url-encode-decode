name := "nice-url-encode-decode"
organization := "biz.neumann"
version := "1.7"
scalaVersion := "2.13.7"
crossScalaVersions := Seq("2.12.5", "2.13.7")

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.13.12",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)