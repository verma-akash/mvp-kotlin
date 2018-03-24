package com.gravity.rxapplication.di.modules

import android.content.Context
import com.gravity.rxapplication.BaseActivity
import com.gravity.rxapplication.di.qualifiers.ActivityQualifier
import com.gravity.rxapplication.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akash Verma on 19/03/18.
 */
@Module
class ActivityModule {

    private val context: BaseActivity

    constructor(context: BaseActivity) {
        this.context = context
    }

    @Provides
    @ActivityScope
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScope
    @ActivityQualifier
    fun providesActivityContext(): BaseActivity {
        return context
    }
}