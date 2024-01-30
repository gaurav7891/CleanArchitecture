// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.16" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.10" apply false

}

buildscript {
    extra.apply {
        set("nav_version", "2.1.0")
        set("coroutines_version", "1.7.3")
        set("room_version", "2.6.1")
        set("glide_version", "4.8.0")
        set("daggerVersion", "2.14.1")
    }

    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.7.6"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}