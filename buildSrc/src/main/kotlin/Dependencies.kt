// Versions for Dependencies AND Build Plugins
const val KOTLIN_VERSION = "1.3.61"
const val ANDROIDX_NAVIGATION_VERSION = "2.2.0-rc02"

object Deps {
    const val MULTIDEX = "androidx.multidex:multidex:2.0.1"

    const val ANDROIDX_ANNOTATIONS = "androidx.annotation:annotation:1.1.0"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
    const val ANDROIDX_RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.1.0-rc01"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val ANDROIDX_CORE = "androidx.core:core-ktx:1.2.0-beta02"
    const val ANDROIDX_ACTIVITY_KTX = "androidx.activity:activity-ktx:1.1.0-rc02"
    const val ANDROIDX_FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.2.0-rc02"

    private const val NAVIGATION_VERSION = "2.1.0"
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"

    // Firebase
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:17.0.0-beta01"
    const val FIREBASE_COMMON_KTX = "com.google.firebase:firebase-common-ktx:17.0.0"
    const val FIREBASE_DB = "com.google.firebase:firebase-firestore-ktx:21.3.1"

    private const val LIFECYCLE_VERSION = "2.2.0-rc02"
    const val ARCH_LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:$LIFECYCLE_VERSION"
    const val ARCH_LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
    const val ARCH_LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val ARCH_LIFECYCLE_SAVE_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-rc02"
    const val LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"

    const val ANDROID_MATERIAL = "com.google.android.material:material:1.1.0-beta02"

    private const val DAGGER_VERSION = "2.25.2"
    const val DAGGER = "com.google.dagger:dagger:$DAGGER_VERSION"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:$DAGGER_VERSION"

    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN_VERSION"
    const val KOTLIN_SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.13.0"
    private const val COROUTINES_VERSION = "1.3.3"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
    const val COROUTINES_PLAY_SERVICES = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$COROUTINES_VERSION" // for "firebase coroutines"

    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"

    private const val VIEWMODEL_INJECT_VERSION = "0.3.2-rc01"
    const val VIEWMODEL_INJECT = "com.vikingsen.inject:viewmodel-inject:$VIEWMODEL_INJECT_VERSION"
    const val VIEWMODEL_INJECT_PROCESSOR = "com.vikingsen.inject:viewmodel-inject-processor:$VIEWMODEL_INJECT_VERSION"

}
