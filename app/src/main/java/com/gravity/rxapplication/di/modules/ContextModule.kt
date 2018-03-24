package com.gravity.rxapplication.di.modules

import android.content.Context
import com.gravity.rxapplication.di.qualifiers.ApplicationContext
import com.gravity.rxapplication.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by Akash Verma on 20/03/18.
 */

@Module
class ContextModule {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    fun providesApplicationContext(): Context {
        return context
    }
}