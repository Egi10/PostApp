object Dependencies {
    object BuildPlugin {
        const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Version.AndroidX.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
        const val material = "com.google.android.material:material:${Version.AndroidX.material}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.AndroidX.constraintLayout}"
    }

    object Testing {
        const val jUnit = "junit:junit:${Version.Testing.jUnit}"
        const val extJunit = "androidx.test.ext:junit:${Version.Testing.extJunit}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Version.Testing.espressoCore}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Version.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"

        // For instrumentation tests
        object Instrumentation {
            const val androidTesting = "com.google.dagger:hilt-android-testing:${Version.hilt}"
            const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        }

        object UnitTest {
            const val androidTesting = "com.google.dagger:hilt-android-testing:${Version.hilt}"
            const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        }
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"
    }
}