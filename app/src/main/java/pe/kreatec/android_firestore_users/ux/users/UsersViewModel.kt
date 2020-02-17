package pe.kreatec.android_firestore_users.ux.users

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pe.kreatec.android_firestore_users.firebase.model.User
import pe.kreatec.android_firestore_users.firebase.repository.UserRepository
import pe.kreatec.android_firestore_users.util.livedata.EmptySingleLiveEvent
import pe.kreatec.android_firestore_users.util.livedata.SingleLiveEvent
import pe.kreatec.android_firestore_users.util.scope.ioScope
import timber.log.Timber

class UsersViewModel
constructor(
    private val userRepository: UserRepository
) : ViewModel(), CoroutineScope by ioScope() {

    val addUsers = EmptySingleLiveEvent()
    val users = SingleLiveEvent<List<User>>()
    val userClicked = SingleLiveEvent<String>() // should post user id value

    fun loadUsers() = launch {
        userRepository.reference.addSnapshotListener { snapshot, exception ->
            if (exception !== null) {
                Timber.e(exception)
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val usersToAssign = mutableListOf<User>()
                snapshot.documents.forEach { document ->
                    document.toObject(User::class.java)?.let {
                        it.uid = document.id
                        usersToAssign.add(it)
                    }
                }
                users.postValue(usersToAssign)
            }
        }
    }

    fun onUserClicked() = userClicked.postValue(null)

    fun onUserClicked(userId: String?) {
        userClicked.postValue(userId)
    }
}