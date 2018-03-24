package com.gravity.rxapplication

import com.gravity.rxapplication.di.ApiServiceHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akash Verma on 18/03/18.
 */
open class BasePresenter<in V : MvpView> : MvpPresenter<V> {

    var mvpView: MvpView? = null
    private val compositeDisposable: CompositeDisposable
    private val apiServiceHelper: ApiServiceHelper

    @Inject
    constructor(apiServiceHelper: ApiServiceHelper, compositeDisposable: CompositeDisposable) {
        this.apiServiceHelper = apiServiceHelper
        this.compositeDisposable = compositeDisposable
    }

    override fun onAttach(view: V) {
        mvpView = view
    }

    override fun onDetach() {
        mvpView = null
        compositeDisposable.dispose()
    }

    fun getCompositeDisposableObject(): CompositeDisposable {
        return compositeDisposable
    }

    fun getApiServiceHelper(): ApiServiceHelper {
        return apiServiceHelper
    }

}