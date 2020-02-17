package pe.kreatec.android_firestore_users.inject

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.kreatec.android_firestore_users.firebase.repository.UserRepository
import pe.kreatec.android_firestore_users.ux.users.UsersViewModel
import pe.kreatec.android_firestore_users.ux.users.details.UserDetailsViewModel

val appModule = module {

    single { UserRepository() }

    viewModel { UsersViewModel(get()) }

    viewModel { UserDetailsViewModel(get()) }

}