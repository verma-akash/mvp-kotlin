package com.gravity.rxapplication.di.components

import com.bumptech.glide.RequestManager
import com.gravity.rxapplication.di.ApiServiceHelper
import com.gravity.rxapplication.di.modules.ApiServiceHelperModule
import com.gravity.rxapplication.di.modules.GlideModule
import com.gravity.rxapplication.di.scopes.ApplicationScope
import dagger.Component

/**
 * Created by Akash Verma on 18/03/18.
 */
@ApplicationScope
@Component(modules = [(ApiServiceHelperModule::class), (GlideModule::class)])
interface ApplicationComponent {

    fun getApiServiceHelper(): ApiServiceHelper

    fun getGlideRequestManager(): RequestManager
}