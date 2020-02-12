package pe.kreatec.android_firestore_users.util.viewholder

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindingViewHolder<out T : ViewDataBinding>(
    itemView: View,
    private val block: BindingViewHolder<T>.() -> Unit
) : RecyclerView.ViewHolder(itemView)