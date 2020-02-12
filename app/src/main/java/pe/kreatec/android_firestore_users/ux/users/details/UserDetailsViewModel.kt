package pe.kreatec.android_firestore_users.ux.users.details

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.vikingsen.inject.viewmodel.ViewModelInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pe.kreatec.android_firestore_users.firebase.model.User
import pe.kreatec.android_firestore_users.firebase.repository.UserRepository
import pe.kreatec.android_firestore_users.util.livedata.EmptySingleLiveEvent
import pe.kreatec.android_firestore_users.util.scope.ioScope

class UserDetailsViewModel
@ViewModelInject constructor(
    private val userRepository: UserRepository
) : ViewModel(), CoroutineScope by ioScope() {

    val names = ObservableField<String>()
    val email = ObservableField<String>()

    val closeListener = EmptySingleLiveEvent()

    private var user: User? = null

    fun loadUserDetails(userId: String) = launch {
        userRepository.getUser(userId)?.let {
            user = it
            names.set(it.names)
            email.set(it.email)
        }
    }

    fun updateUserDetails() = launch {
        if (user == null) user = User()
        user?.names = names.get()
        user?.email = email.get()
        user?.let { userRepository.saveOrUpdateUser(it) }
        close()
    }

    fun close() = closeListener.postCall()

}