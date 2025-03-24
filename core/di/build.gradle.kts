plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)

    // KSP
    id("com.google.devtools.ksp") version "2.1.20-1.0.31"
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {

    // Dagger
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    // KotlinX
    implementation(libs.kotlinx.coroutines.core)
}
