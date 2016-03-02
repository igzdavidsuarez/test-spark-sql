name := "spkar-sql-test"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.10" % "1.6.0",
  "org.apache.spark" % "spark-sql_2.10" % "1.6.0",
  "mysql" % "mysql-connector-java" % "5.1.38"

)

resolvers ++= Seq(
  "clojars.org" at "http://clojars.org/repo"
)

scalacOptions += "-Yresolve-term-conflict:package"