package com.vhontar.dagger2.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.vhontar.dagger2.R
import com.vhontar.dagger2.databinding.ActivityAuthBinding
import com.vhontar.dagger2.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var viewDataBinding: ActivityAuthBinding

    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_auth
        )

        viewDataBinding.btnLogin.setOnClickListener {
            if (viewDataBinding.tvUserId.text.toString().isEmpty())
                return@setOnClickListener

            viewModel.authWithId(viewDataBinding.tvUserId.text.toString().toInt())
        }

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        viewModel.observeUser().observe(this, Observer {
            when(it.status) {
                AuthResource.AuthStatus.LOADING -> {
                    viewDataBinding.pbLoader.visibility = View.VISIBLE
                }
                AuthResource.AuthStatus.AUTHENTICATED -> {
                    viewDataBinding.pbLoader.visibility = View.GONE
                    Log.d("TEST", "authenticated")
                }
                AuthResource.AuthStatus.ERROR -> {
                    viewDataBinding.pbLoader.visibility = View.GONE
                    Toast.makeText(this, it.message?.plus("\nDid you enter a number between 1 and 10?"), Toast.LENGTH_SHORT).show()
                }
                AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                    viewDataBinding.pbLoader.visibility = View.GONE
                }
            }
        })

        requestManager
            .load(logo)
            .into(viewDataBinding.ivLoginLogo)
    }
}