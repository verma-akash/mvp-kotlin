package com.gravity.rxapplication.di.modules

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.RequestManager
import com.gravity.rxapplication.di.qualifiers.ApplicationContext
import com.gravity.rxapplication.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Akash Verma on 20/03/18.
 */
@Module(includes = [(ContextModule::class)])
class GlideModule {

    @Provides
    @ApplicationScope
    fun providesGlideRequestManager(@ApplicationContext context: Context): RequestManager {
        return Glide.with(context)
    }
}