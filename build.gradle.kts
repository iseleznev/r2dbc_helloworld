import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("kapt") version "1.5.21"
    kotlin("plugin.spring") version "1.5.31"

    id("org.flywaydb.flyway") version "7.8.1"
}

group = "org.seleznyoviyu.klab"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-noarg:1.1.50")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:2.6.4")
    //implementation("org.springframework.boot:spring-boot-starter-web:2.6.4")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
    //implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.flywaydb:flyway-core:8.5.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.0-native-mt")
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")
    implementation("io.r2dbc:r2dbc-postgresql:0.8.10.RELEASE")
    implementation("org.postgresql:postgresql:42.3.3")
    //implementation("com.zaxxer:HikariCP:4.0.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.4")
    testImplementation("io.projectreactor:reactor-test:3.4.15")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
