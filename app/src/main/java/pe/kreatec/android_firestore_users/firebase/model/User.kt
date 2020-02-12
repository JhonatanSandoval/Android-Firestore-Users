package pe.kreatec.android_firestore_users.firebase.model

import com.google.firebase.Timestamp
import java.util.Date

data class User(
    var uid: String = "",
    var names: String? = "",
    var email: String? = "",
    val createdAt: Timestamp = Timestamp(Date())
) {
    override fun toString(): String = "User: $names"

    companion object {
        const val COLLECTION_NAME = "users"
    }
}