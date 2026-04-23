# MiniApp SDK Integration Guide

## Overview
This repository provides instructions to integrate the MiniApp SDK into your Android application.

---

## Step 1: Configure GitHub Credentials
```Store your GitHub credentials securely in either local.properties or gradle.properties.```
```Ensure these files are added to .gitignore and never committed to version control. ```

```local.properties or gradle.properties
    GITHUB_USERNAME= XXX-XX-XXXXX
    GITHUB_PASSWORD= XXX-XX-XXXXX
```

## Step 2: Add Maven Repository
```Update your settings.gradle.kts to include the GitHub Packages repository: 
 dependencyResolutionManagement {
 repositories {
    maven {
        url "https://maven.pkg.github.com/AscendionPlatformEngineering/mini-program-android-sdk"
        credentials {
            username = "GITHUB_USERNAME"
            password = "GITHUB_PASSWORD"
        }
    }
  }
}
```

## Step 3: Load Local Properties

```Add a helper function in settings.gradle.kts to load credentials from local.properties:
   fun loadLocalProperties(): Properties {
    val propsFile = rootDir.resolve("local.properties")
    if (!propsFile.exists()) {
        throw GradleException("local.properties file not found at ${propsFile.absolutePath}")
    }

    return Properties().apply {
        propsFile.inputStream().use { load(it) }
    }
 }
```
## Step 4: Sync the Project

```Sync your project to download dependencies and complete the setup.You are now ready to use the Mini Program SDK in your application.
```

