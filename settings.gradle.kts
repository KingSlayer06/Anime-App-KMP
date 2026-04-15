rootProject.name = "Anime_App"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":shared")

include(":core:network")
include(":core:ui")
include(":core:util")

include(":feature:explore:data")
include(":feature:explore:domain")
include(":feature:explore:presentation")

include(":feature:home:data")
include(":feature:home:domain")
include(":feature:home:presentation")

include(":feature:myLibrary:data")
include(":feature:myLibrary:domain")
include(":feature:myLibrary:presentation")

include(":feature:details:data")
include(":feature:details:domain")
include(":feature:details:presentation")