pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
            }
        }
    }
    repositories {
        gradlePluginPortal()
        maven(url = "https://repo.spring.io/libs-milestone")
    }
}

rootProject.name = "makeit19-dockerizing-spring-boot"
