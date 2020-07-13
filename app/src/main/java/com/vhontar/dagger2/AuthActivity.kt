package com.vhontar.dagger2

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.RequestManager
import com.vhontar.dagger2.databinding.ActivityAuthBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var viewDataBinding: ActivityAuthBinding

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        requestManager
            .load(logo)
            .into(viewDataBinding.loginLogo)
    }
}