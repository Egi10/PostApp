object Dependencies {
    object BuildPlugin {
        const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
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
}