plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("org.jetbrains.kotlin.kapt") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
}

version = "0.1"
group = "org.ansel"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
    jcenter()
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("org.ansel.*")
    }
}

dependencies {
    kapt("io.micronaut.jaxrs:micronaut-jaxrs-processor")
    kapt("io.micronaut.spring:micronaut-spring-annotation")
    kapt("io.micronaut.spring:micronaut-spring-boot")
    implementation("io.micronaut:micronaut-validation")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.jaxrs:micronaut-jaxrs-server")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtime("io.micronaut.spring:micronaut-spring-boot")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
}


application {
    mainClass.set("org.ansel.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("14")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "14"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "14"
        }
    }


}

