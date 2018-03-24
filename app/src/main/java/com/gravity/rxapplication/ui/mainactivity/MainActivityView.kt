package com.gravity.rxapplication.ui.mainactivity

import com.gravity.rxapplication.MvpView
import com.gravity.rxapplication.models.FollowersProfile

/**
 * Created by Akash Verma on 18/03/18.
 */
interface MainActivityView : MvpView {
    fun initializeData(followersProfileArrayList: ArrayList<FollowersProfile>)
    fun showErrorMsg()
}
