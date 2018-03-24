package com.gravity.rxapplication.ui.mainactivity

import android.util.Log
import com.gravity.rxapplication.BasePresenter
import com.gravity.rxapplication.di.ApiServiceHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Akash Verma on 18/03/18.
 */
class MainActivityPresenter @Inject constructor(apiServiceHelper: ApiServiceHelper, compositeDisposable: CompositeDisposable) : BasePresenter<MainActivityView>(apiServiceHelper, compositeDisposable) {

    fun loadFollowers(userName: String) {
        mvpView!!.showLoading()
        getCompositeDisposableObject().add(getApiServiceHelper().getFollowers(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mvpView!!.hideLoading()
                    if(it.size>0){
                        (mvpView!! as MainActivity).initializeData(it)
                    } else {
                        (mvpView!! as MainActivity).initializeData(it)
                    }
                }, {

                }))
    }

}