plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.done"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.done"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.core:core-ktx:1.12.0")

    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("androidx.compose.material3:material3:1.2.0")


    // Jetpack Compose BOM
    val composeBom = platform("androidx.compose:compose-bom:2024.02.01")
    implementation(composeBom)

    // Jetpack Compose UI
    implementation("androidx.activity:activity-compose")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Debugging & Preview
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Unit Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.compose.ui:ui:1.5.0")  // Ensure this is the latest Compose version
    implementation ("androidx.compose.material3:material3:1.1.0") // For Material3 components like Card
    implementation ("androidx.compose.material:material:1.5.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0") // For Preview support
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("androidx.activity:activity-compose:1.6.0")

}
