name := """nice-url-encode-decode""".stripMargin

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/daandi/nice-url-encode-decode</url>
    <licenses>
      <license>
        <name>BSD-style</name>
        <url>http://www.opensource.org/licenses/bsd-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:daandi/nice-url-encode-decode.git</url>
      <connection>scm:git:git@github.com:daandi/nice-url-encode-decode.git</connection>
    </scm>
    <developers>
      <developer>
        <id>daandi</id>
        <name>Andreas Neumann</name>
        <url>http://www.neumann.biz</url>
      </developer>
    </developers>
  )

