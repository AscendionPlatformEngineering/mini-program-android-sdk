plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ascendion.miniprogramandroidsdk"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ascendion.miniprogramandroidsdk"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeVersion.toString() // Match Compose version
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.material3)
    implementation(libs.androidx.ui.graphics)

    // Jetpack Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation (libs.androidx.ui.compose.tooling.preview)
    implementation (libs.androidx.activity.compose)
    implementation (libs.androidx.lifecycle.viewmodel.compose)

    // Navigation
    implementation (libs.androidx.navigation.compose)

    // Image loading
    implementation (libs.coil.compose)

    // Pager for banners
    implementation (libs.accompanist.pager)
    implementation (libs.accompanist.pager.indicators)
    debugImplementation(libs.androidx.ui.tooling)

    implementation(libs.mini.program.sdk)
}