/**
 * Fixing mavenCentral Red in New AndroidStudio
 * https://stackoverflow.com/questions/65531211/cannot-access-java-lang-object-which-is-a-supertype-of-org-gradle-api-artifac
 */

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}