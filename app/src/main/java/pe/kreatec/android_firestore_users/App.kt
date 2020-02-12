package pe.kreatec.android_firestore_users

import android.app.Application
import pe.kreatec.android_firestore_users.inject.AppModule
import pe.kreatec.android_firestore_users.inject.Injector
import timber.log.Timber

class App : Application() {

    init {
        Injector.init(AppModule(this))
    }

    override fun onCreate() {
        super.onCreate()

        Injector.get().inject(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}