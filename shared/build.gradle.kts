import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.skie)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true

            export(projects.core.network)
            export(projects.core.util)
            
            export(projects.feature.home.data)
            export(projects.feature.home.domain)
            export(projects.feature.home.presentation)

            export(projects.feature.explore.data)
            export(projects.feature.explore.domain)
            export(projects.feature.explore.presentation)

            export(projects.feature.details.data)
            export(projects.feature.details.domain)
            export(projects.feature.details.presentation)
        }
    }
    
    sourceSets {
        androidMain.dependencies {

        }
        commonMain.dependencies {
            api(projects.core.network)
            api(projects.core.ui)

            api(projects.feature.home.data)
            api(projects.feature.home.domain)
            api(projects.feature.home.presentation)

            api(projects.feature.explore.data)
            api(projects.feature.explore.domain)
            api(projects.feature.explore.presentation)

            api(projects.feature.details.data)
            api(projects.feature.details.domain)
            api(projects.feature.details.presentation)

            implementation(libs.koin.core)
        }
        iosMain.dependencies {

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.kingslayer06.anime_app.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
