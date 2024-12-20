plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt") // Required for Room annotation processing
}

android {
    namespace = "com.example.bitsleep"
    compileSdk = 34 // Use the latest compile SDK for compatibility

    defaultConfig {
        applicationId = "com.example.bitsleep"
        minSdk = 21 // Minimum SDK supported by your app
        targetSdk = 34 // Match with the compile SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // Java and Kotlin Compatibility
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11 // Use Java 11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11" // Match Kotlin JVM target to Java 11
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
}

dependencies {
    // Core and AppCompat
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1") // Room Coroutine Support

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Lifecycle (if needed)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Unit Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
