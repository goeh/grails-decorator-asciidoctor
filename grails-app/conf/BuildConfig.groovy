grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
    }
    log "warn"
    legacyResolve false
    repositories {
        grailsCentral()
        mavenCentral()
        mavenRepo "http://labs.technipelago.se/repo/plugins-releases-local/"
    }
    dependencies {
        compile "org.asciidoctor:asciidoctor-java-integration:0.1.3"
    }

    plugins {
        build(":tomcat:$grailsVersion",
              ":release:2.2.1",
              ":rest-client-builder:1.0.3") {
            export = false
        }
        compile ":decorator:1.0"
    }
}
