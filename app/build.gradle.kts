val ktor_version: String by rootProject
val kotlin_version: String by rootProject
val logback_version: String by rootProject
val koin_version: String by rootProject

plugins {
    application
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.3.3")
    compile("io.ktor:ktor-server-netty:$ktor_version")
    compile("ch.qos.logback:logback-classic:$logback_version")
    compile("io.ktor:ktor-metrics:$ktor_version")
    compile("io.ktor:ktor-server-core:$ktor_version")
    compile("io.ktor:ktor-gson:$ktor_version")
    compile("io.ktor:ktor-client-core:$ktor_version")
    compile("io.ktor:ktor-client-apache:$ktor_version")
    compile("io.ktor:ktor-client-gson:$ktor_version")
    compile("org.apache.httpcomponents:httpasyncclient:4.1.4")
    compile("io.ktor:ktor-websockets:$ktor_version")
    compile("io.ktor:ktor-pebble:$ktor_version")

    compile("com.github.zensum:ktor-health-check:011a5a8")
    compile("org.koin:koin-ktor:$koin_version")
    compile("net.jodah:expiringmap:0.5.9")
    compile("com.github.ben-manes.caffeine:caffeine:2.8.0")
    compile("com.vladsch.flexmark:flexmark-all:0.50.44")
    compile("me.gosimple:nbvcxz:1.4.3")
    compile("com.github.zensum:ktor-prometheus-feature:-SNAPSHOT")
    compile("io.prometheus:simpleclient:0.8.0")
    compile("io.prometheus:simpleclient_common:0.8.0")
    compile("io.prometheus:simpleclient_logback:0.8.0")
    compile("io.prometheus:simpleclient_hotspot:0.8.0")
    compile("io.prometheus:simpleclient_caffeine:0.8.0")
    compile("io.prometheus:simpleclient_logback:0.8.0")
    compile(project(":data:base"))
    compile(project(":commons"))

    testCompile("io.ktor:ktor-server-tests:$ktor_version")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

tasks.withType<Jar> {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to application.mainClassName
            )
        )
    }
}