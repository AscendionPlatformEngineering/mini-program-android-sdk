import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

fun loadLocalProperties(): Properties {
    val propsFile = rootDir.resolve("local.properties")
    if (!propsFile.exists()) {
        throw GradleException("local.properties file not found at ${propsFile.absolutePath}")
    }

    return Properties().apply {
        propsFile.inputStream().use { load(it) }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/AscendionPlatformEngineering/mini-program-android-sdk")
            val localProperties = loadLocalProperties()
            credentials {
                username = localProperties.getProperty("github_username")
                password = localProperties.getProperty("github_token")
            }
        }
    }
}

rootProject.name = "mini-program-android-sdk"
include(":app")
 