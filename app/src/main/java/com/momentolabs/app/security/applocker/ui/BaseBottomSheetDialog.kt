package com.momentolabs.app.security.applocker.ui

//import dagger.android.support.HasSupportFragmentInjector
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseBottomSheetDialog<VM: ViewModel> : BottomSheetDialogFragment() {//

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModel())
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

//    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
//        return childFragmentInjector
//    }

}