plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.9.21"
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.itbenevides.myname"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.itbenevides.myname"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v270)
    implementation(libs.androidx.activity.compose.v182)
    implementation(platform(libs.androidx.compose.bom.v20240901))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.logging)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt (libs.kotlinx.metadata.jvm)

    implementation(libs.coil)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(platform(libs.compose.bom.v20230800))
    androidTestImplementation(libs.ui.test.junit4)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    testImplementation (libs.mockito.core)
    testImplementation (libs.core.testing)
    testImplementation(libs.mockk)
    testImplementation (libs.kotlinx.coroutines.test)

    /* rx */
    implementation ("io.reactivex:rxandroid:1.2.1")
    implementation ("io.reactivex:rxjava:1.3.2")


    /* retrofit, gson */
    implementation ("com.squareup.retrofit2:retrofit:2.4.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava:2.3.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.8.1")
    implementation ("com.squareup.retrofit2:converter-scalars:2.4.0")
}

kapt {
    correctErrorTypes = true
}