import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    id("org.springframework.boot") version "2.2.0.RC1"
    id("com.gorylenko.gradle-git-properties") version "2.2.0"
    id("com.google.cloud.tools.jib") version "1.6.1"
}

group = "demo"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven(url = "https://repo.spring.io/libs-milestone/")
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
    }
}

jib {
    from {
        image = "adoptopenjdk:8u222-b10-jre-hotspot"
    }
}
