plugins {
    kotlin("jvm") version "2.1.10"
    id("io.ktor.plugin") version "3.1.1"
    kotlin("plugin.serialization") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val ktor_version = "3.1.1"
    val logback_version = "1.2.11"

    // Podstawowe funkcjonalności Ktor
    implementation("io.ktor:ktor-server-core:$ktor_version")
    // Silnik Netty, który uruchamia serwer
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    // Plugin do obsługi StatusPages (obsługa błędów)
    implementation("io.ktor:ktor-server-status-pages:$ktor_version")
    // Logging (przydatny przy debugowaniu i monitoringu)
    implementation("ch.qos.logback:logback-classic:$logback_version")
    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    // Ktor Content Negotiation
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.xerial:sqlite-jdbc:3.41.2.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}

application {
    // Główna klasa Twojej aplikacji
    mainClass.set("org.example.MainKt")
}