name := "infinispan-operator"
version := "0.0.1"
scalaVersion := "2.12.6"
mainClass in Compile := Some("io.radanalytics.operator.Entrypoint") 

libraryDependencies += "io.radanalytics" % "abstract-operator" % "0.1.8"
