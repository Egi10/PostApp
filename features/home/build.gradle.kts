import extensions.compose
import extensions.coroutine
import extensions.hilt

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consumerProguardFiles)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.Compose.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.lifecycleViewModel)
    implementation(Dependencies.AndroidX.fragmentKtx)
    testImplementation(Dependencies.Testing.jUnit)
    androidTestImplementation(Dependencies.Testing.extJunit)
    androidTestImplementation(Dependencies.Testing.espressoCore)
    // Hilt
    hilt()
    // Coroutine
    coroutine()
    // Compose
    compose()
    // Domain
    implementation(project(Modules.domain))
    // Abstraction
    implementation(project(Modules.Libraries.abstraction))
    // Component
    implementation(project(Modules.Libraries.component))
    // Users
    implementation(project(Modules.Features.users))
}