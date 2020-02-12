package pe.kreatec.android_firestore_users.ux.users.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.navArgs
import com.vikingsen.inject.viewmodel.ViewModelFactory
import pe.kreatec.android_firestore_users.R
import pe.kreatec.android_firestore_users.databinding.ActivityUserDetailsBinding
import pe.kreatec.android_firestore_users.inject.Injector
import javax.inject.Inject

class UserDetailsActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy { viewModelFactory.create(UserDetailsViewModel::class.java) }

    private val args: UserDetailsActivityArgs by navArgs()
    private lateinit var binding: ActivityUserDetailsBinding

    init {
        Injector.get().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details)
        setUpViewModel()
        validateArguments()
    }

    private fun validateArguments() {
        args.userId?.let {
            viewModel.loadUserDetails(it)
        }
    }

    private fun setUpViewModel() {
        binding.viewModel = viewModel
        viewModel.closeListener.observe(this, Observer { finish() })
    }
}
