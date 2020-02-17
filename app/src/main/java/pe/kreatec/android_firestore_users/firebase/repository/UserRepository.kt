package pe.kreatec.android_firestore_users.firebase.repository

import kotlinx.coroutines.tasks.await
import pe.kreatec.android_firestore_users.firebase.FirebaseSource
import pe.kreatec.android_firestore_users.firebase.model.User

class UserRepository {
    val reference by lazy { FirebaseSource.database.collection(User.COLLECTION_NAME) }

    suspend fun getUser(userId: String): User? {
        val dbObject = reference.document(userId).get().await()
        return dbObject.toObject(User::class.java)?.apply {
            uid = dbObject.id
        }
    }

    suspend fun saveOrUpdateUser(user: User) {
        if (user.uid.isNotEmpty()) {
            getUser(user.uid)?.let {
                updateUser(user)
            }
        } else {
            insertUser(user)
        }
    }

    private suspend fun insertUser(user: User) = reference.add(user).await()

    private suspend fun updateUser(user: User) = reference.document(user.uid).set(user).await()
}