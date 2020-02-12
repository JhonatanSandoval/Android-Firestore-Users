package pe.kreatec.android_firestore_users.inject

object Injector {

    private var appComponent: AppComponent? = null

    @JvmStatic
    @Synchronized
    fun init(appModule: AppModule) {
        appComponent = DaggerAppComponent.builder()
            .appModule(appModule)
            .build()
    }

    @JvmStatic
    @Synchronized
    fun get(): AppComponent {
        appComponent?.let { return it }
        throw IllegalArgumentException("AppComponent must be initialized first, with init() method")
    }
}