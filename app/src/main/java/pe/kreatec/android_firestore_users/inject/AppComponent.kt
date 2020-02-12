package pe.kreatec.android_firestore_users.inject

import android.app.Application
import dagger.Component
import pe.kreatec.android_firestore_users.App
import pe.kreatec.android_firestore_users.ux.users.UsersFragment
import pe.kreatec.android_firestore_users.ux.users.details.UserDetailsActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun inject(fragment: UsersFragment)
    fun inject(activity: UserDetailsActivity)

    //
    fun application(): Application
}