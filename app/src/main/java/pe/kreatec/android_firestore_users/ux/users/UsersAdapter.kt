package pe.kreatec.android_firestore_users.ux.users

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import pe.kreatec.android_firestore_users.R
import pe.kreatec.android_firestore_users.databinding.ItemUserBinding
import pe.kreatec.android_firestore_users.firebase.model.User
import pe.kreatec.android_firestore_users.util.ext.inflater
import pe.kreatec.android_firestore_users.util.viewholder.BindingViewHolder

class UsersAdapter constructor(
    private val usersViewModel: UsersViewModel
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    var users = listOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position) ?: return
        holder.binding.usesViewModel = usersViewModel
        holder.binding.user = user
    }

    override fun getItemCount(): Int = users.size
    private fun getItem(position: Int): User? = users[position]

    class UserViewHolder(
        parent: ViewGroup,
        val binding: ItemUserBinding = DataBindingUtil.inflate(parent.inflater(), R.layout.item_user, parent, false)
    ) : BindingViewHolder<ItemUserBinding>(binding.root, {})

}