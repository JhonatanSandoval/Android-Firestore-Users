import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

// Manifest version information
val buildTime = Date().time
val versionCodeAppName = ""
val minVersionCode = 1
val appVersionCode = VersionCode.readVersionCode(versionCodeAppName, minVersionCode)
val appVersionName = "1.0.0 ($appVersionCode.${System.getenv("BUILD_NUMBER")})"

kapt {
    javacOptions {
        // Increase the max count of errors from annotation processors. (Default is 100)
        option("-Xmaxerrs", 500)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


android {
    compileSdkVersion(AndroidSdk.COMPILE)

    defaultConfig {
        minSdkVersion(AndroidSdk.MIN)
        targetSdkVersion(AndroidSdk.TARGET)

        versionCode = appVersionCode
        versionName = appVersionName

        buildConfigField("String", "USER_AGENT_APP_NAME", "\"Firestore-AndroidApp\"")

        multiDexEnabled = true

        // Espresso
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = true
        disable("InvalidPackage")
    }

    dexOptions {
        javaMaxHeapSize = "4g"
    }

    buildTypes {
        getByName("release") {
            versionNameSuffix = ""
        }
        getByName("debug") {
            versionNameSuffix = " DEV"
            applicationIdSuffix = ".dev"
            buildConfigField(
                "long",
                "BUILD_TIME",
                "0l"
            ) // to improve build times, do allow change on every build
        }
    }

    flavorDimensions("env")
    productFlavors {
        create("dev") {
            buildConfigField("String", "BASE_URL", "\"http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/\"")
        }
        create("prd") {
            buildConfigField("String", "BASE_URL", "\"http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/\"")
        }
    }

}

dependencies {
    implementation(Deps.MULTIDEX)

    implementation(Deps.ANDROIDX_APPCOMPAT)
    implementation(Deps.ANDROIDX_RECYCLERVIEW)
    implementation(Deps.ANDROID_MATERIAL)
    implementation(Deps.ANDROIDX_ANNOTATIONS)
    implementation(Deps.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(Deps.ANDROIDX_CORE)
    implementation(Deps.ANDROIDX_ACTIVITY_KTX)
    implementation(Deps.ANDROIDX_FRAGMENT_KTX)

    implementation(Deps.KOTLIN_STD_LIB)
    implementation(Deps.KOTLIN_SERIALIZATION)
    implementation(Deps.COROUTINES_CORE)
    implementation(Deps.COROUTINES_ANDROID)
    implementation(Deps.TIMBER)

    implementation(Deps.FIREBASE_COMMON_KTX)
    implementation(Deps.FIREBASE_DB)
    implementation(Deps.FIREBASE_CRASHLYTICS)

    implementation(Deps.DAGGER)
    implementation(Deps.NAVIGATION_FRAGMENT_KTX)
    implementation(Deps.NAVIGATION_UI_KTX)
    kapt(Deps.DAGGER_COMPILER)

    implementation(Deps.VIEWMODEL_INJECT)
    kapt(Deps.VIEWMODEL_INJECT_PROCESSOR)

    implementation(Deps.ARCH_LIFECYCLE_EXT)
    implementation(Deps.ARCH_LIFECYCLE_RUNTIME)
    implementation(Deps.ARCH_LIFECYCLE_VIEWMODEL)
    implementation(Deps.ARCH_LIFECYCLE_SAVE_STATE)
    implementation(Deps.LIVE_DATA_KTX)

}

tasks.register("incrementVersionCode") {
    doLast {
        VersionCode.incrementVersionCode(versionCodeAppName, minVersionCode)
    }
}

apply(plugin = "androidx.navigation.safeargs.kotlin")