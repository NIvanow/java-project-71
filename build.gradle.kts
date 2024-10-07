plugins {
    id("java")
    application
    id("checkstyle")
    id ("org.graalvm.buildtools.native") version "0.10.2"
    distribution

}


group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.6")
    compileOnly ("info.picocli:picocli-codegen:4.7.6")
    annotationProcessor ("info.picocli:picocli-codegen:4.7.6")
}



application {
    mainClass.set("hexlet.code.App")
}

tasks.test {
    useJUnitPlatform()

}