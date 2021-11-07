package extensions

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.coroutine() {
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.android)
    testImplementation(Dependencies.Coroutines.test)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)
    androidTestImplementation(Dependencies.Hilt.Instrumentation.androidTesting)
    kaptAndroidTest(Dependencies.Hilt.Instrumentation.compiler)
    testImplementation(Dependencies.Hilt.UnitTest.androidTesting)
    kaptTest(Dependencies.Hilt.UnitTest.compiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)
}

fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: String) {
    add("kapt", dependencyNotation)
}

fun DependencyHandler.testImplementation(dependencyNotation: String) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandler.kaptTest(dependencyNotation: String) {
    add("kaptTest", dependencyNotation)
}

fun DependencyHandler.androidTestImplementation(dependencyNotation: String) {
    add("androidTestImplementation", dependencyNotation)
}

fun DependencyHandler.kaptAndroidTest(dependencyNotation: String) {
    add("kaptAndroidTest", dependencyNotation)
}