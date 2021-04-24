resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/sbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.8.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.19")