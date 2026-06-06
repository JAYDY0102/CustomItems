plugins {
    kotlin("jvm") version "2.2.20"
    id("java")
}

group = "org.jaydy0102"
version = "1.8.0-SNAPSHOT"

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://central.sonatype.com/repository/maven-snapshots/")
    }
    dependencies {
        classpath("com.gradleup.shadow:shadow-gradle-plugin:9.4.2")
    }
}

repositories {
    maven("https://repo.dmulloy2.net/nexus/repository/public/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies{
    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")
    compileOnly("net.dmulloy2:ProtocolLib:5.4.0")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

apply(plugin = "com.gradleup.shadow")

tasks.test {
    useJUnitPlatform()
}