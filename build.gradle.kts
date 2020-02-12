buildscript {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("com.github.ben-manes:gradle-versions-plugin:0.27.0") // version plugin support
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$KOTLIN_VERSION")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$ANDROIDX_NAVIGATION_VERSION")
        classpath("com.google.gms:google-services:4.3.3")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01")
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://jitpack.io") // ihsanbal:LoggingInterceptor
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}