package com.gravity.rxapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gravity.rxapplication.di.components.ActivityComponent
import com.gravity.rxapplication.di.components.DaggerActivityComponent
import com.gravity.rxapplication.di.modules.ActivityModule

/**
 * Created by Akash Verma on 18/03/18.
 */
abstract class BaseActivity : AppCompatActivity(), MvpView {

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(RxApplication.get(this).getComponent())
                .build()

    }

    fun getActivityComponent(): ActivityComponent {
        return activityComponent
    }
}