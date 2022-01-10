sonatypeProfileName := "biz.neumann"
publishMavenStyle := true
Test / publishArtifact := false
pomIncludeRepository := { _ => false }

Global /pomExtra := (
  <url>https://github.com/daandi/nice-url-encode-decode</url>
    <licenses>
      <license>
        <name>BSD-style</name>
        <url>http://www.opensource.org/licenses/bsd-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <developerConnection>git@github.com:daandi/nice-url-encode-decode.git</developerConnection>
      <connection>scm:git:git@github.com:daandi/nice-url-encode-decode.git</connection>
      <url>https://github.com/daandi/nice-url-encode-decode</url>
    </scm>
    <developers>
      <developer>
        <id>daandi</id>
        <name>Andreas Neumann</name>
        <url>http://www.neumann.biz</url>
      </developer>
    </developers>
  )
