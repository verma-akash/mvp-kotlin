package com.gravity.rxapplication.di.components

import com.gravity.rxapplication.di.modules.ActivityModule
import com.gravity.rxapplication.di.scopes.ActivityScope
import com.gravity.rxapplication.ui.mainactivity.MainActivity
import dagger.Component

/**
 * Created by Akash Verma on 19/03/18.
 */

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}