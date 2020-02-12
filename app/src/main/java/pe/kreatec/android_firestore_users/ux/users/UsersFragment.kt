package pe.kreatec.android_firestore_users.ux.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vikingsen.inject.viewmodel.ViewModelFactory
import pe.kreatec.android_firestore_users.R
import pe.kreatec.android_firestore_users.databinding.FragmentUsersBinding
import pe.kreatec.android_firestore_users.inject.Injector
import pe.kreatec.android_firestore_users.util.ui.BaseFragment
import javax.inject.Inject

class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    override val layout: Int = R.layout.fragment_users

    private val navController by lazy { NavHostFragment.findNavController(this) }

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy { viewModelFactory.create(UsersViewModel::class.java) }

    private val adapter by lazy { UsersAdapter(viewModel) }

    init {
        Injector.get().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindView(inflater, container)
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        binding.rvUsers.adapter = adapter
    }

    override fun setUpViewModel() {
        binding.usersViewModel = viewModel

        viewModel.users.observeNotNull {
            adapter.users = it
        }
        viewModel.userClicked.observe {
            val userId = it
            val action = UsersFragmentDirections.actionUsersFragmentToUserDetailsActivity(userId)
            navController.navigate(action)
        }
        viewModel.loadUsers()
    }

}