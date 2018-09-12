name := "foo-operator"
version := "0.0.2"
scalaVersion := "2.12.6"
mainClass in Compile := Some("io.radanalytics.operator.Entrypoint") 

libraryDependencies += "io.radanalytics" % "abstract-operator" % "0.3.5"
resolvers += Resolver.mavenLocal

assemblyMergeStrategy in assembly := {
  case "log4j.properties"                            => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}