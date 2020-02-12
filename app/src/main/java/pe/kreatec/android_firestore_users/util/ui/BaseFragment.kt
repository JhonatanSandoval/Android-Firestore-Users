package pe.kreatec.android_firestore_users.util.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import timber.log.Timber

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var binding: T
    protected abstract fun setUpViewModel()
    protected abstract val layout: Int

    protected fun bindView(inflater: LayoutInflater, parent: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layout, parent, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
    }

    @MainThread
    protected inline fun <T> LiveData<T>.observe(crossinline onChanged: (T?) -> Unit): Observer<T> {
        val wrappedObserver = Observer<T> { value ->
            onChanged.invoke(value)
        }
        observe(viewLifecycleOwner, wrappedObserver)
        return wrappedObserver
    }

    @MainThread
    protected inline fun <T : Any> LiveData<T>.observeKt(crossinline onChanged: (T) -> Unit): Observer<T> {
        val wrappedObserver = Observer<T> { value ->
            if (value != null) {
                onChanged.invoke(value)
            } else {
                Timber.i("Cannot post null value to a non-null LiveData")
            }
        }
        observe(this@BaseFragment, wrappedObserver)
        return wrappedObserver
    }

    @MainThread
    protected inline fun <T> LiveData<T?>.observeNotNull(crossinline onChanged: (T) -> Unit): Observer<T?> {
        val wrappedObserver = Observer<T?> { value ->
            if (value != null) {
                onChanged.invoke(value)
            }
        }
        observe(viewLifecycleOwner, wrappedObserver)
        return wrappedObserver
    }

    @MainThread
    protected inline fun <T> LiveData<T>.observeByFragment(crossinline onChanged: (T?) -> Unit): Observer<T> {
        val wrappedObserver = Observer<T> { value -> onChanged.invoke(value) }
        observe(this@BaseFragment, wrappedObserver)
        return wrappedObserver
    }

    @MainThread
    protected inline fun <T : Any> LiveData<T>.observeByFragmentKt(crossinline onChanged: (T) -> Unit): Observer<T> {
        val wrappedObserver = Observer<T> { value ->
            if (value != null) {
                onChanged.invoke(value)
            } else {
                Timber.i("Cannot post null value to a non-null LiveData")
            }
        }
        observe(this@BaseFragment, wrappedObserver)
        return wrappedObserver
    }

    @MainThread
    protected inline fun <T> LiveData<T?>.observeNotNullByFragment(crossinline onChanged: (T) -> Unit): Observer<T?> {
        val wrappedObserver = Observer<T?> { value ->
            if (value != null) {
                onChanged.invoke(value)
            }
        }
        observe(this@BaseFragment, wrappedObserver)
        return wrappedObserver
    }

}