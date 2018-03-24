package com.gravity.rxapplication

import android.app.Activity
import android.app.Application
import com.gravity.rxapplication.di.components.ApplicationComponent
import com.gravity.rxapplication.di.components.DaggerApplicationComponent
import com.gravity.rxapplication.di.modules.ContextModule

/**
 * Created by Akash Verma on 18/03/18.
 */
class RxApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun get(activity: Activity): RxApplication {
            return activity.application as RxApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()

    }

    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}