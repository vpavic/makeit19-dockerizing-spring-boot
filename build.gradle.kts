import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    id("org.springframework.boot") version "2.1.8.RELEASE"
    id("com.gorylenko.gradle-git-properties") version "2.2.0"
    id("com.google.cloud.tools.jib") version "1.6.1"
}

group = "demo"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

springBoot {
    buildInfo {
        properties {
            time = null
        }
        doLast {
            val f = File(destinationDir, "build-info.properties")
            f.writeText(f.readLines().filter { !it.startsWith("#") }.joinToString("\n"))
        }
    }
}

jib {
    from {
        image = "adoptopenjdk:8u222-b10-jre-hotspot"
    }
}
