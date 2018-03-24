package com.gravity.rxapplication

/**
 * Created by Akash Verma on 18/03/18.
 */
interface MvpPresenter<in V : MvpView> {

    fun onAttach(view: V)

    fun onDetach()
}