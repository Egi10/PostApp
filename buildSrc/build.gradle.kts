/**
 * Fixing mavenCentral Red in New AndroidStudio
 * https://stackoverflow.com/questions/65531211/cannot-access-java-lang-object-which-is-a-supertype-of-org-gradle-api-artifac
 */

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

    // Depend on the default Gradle API since we want to build a custom plugin
    implementation(gradleApi())
    implementation(localGroovy())
}