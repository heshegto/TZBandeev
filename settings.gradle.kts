pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TZ Bandeev"
include(":app")
include(":core")
include(":core:ui")
include(":core:product_item")
include(":feature")
include(":feature:auth")
include(":feature:all_courses")
include(":feature:favourite_courses")
include(":feature:account_management")
