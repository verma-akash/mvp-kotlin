package com.gravity.rxapplication.di

import com.gravity.rxapplication.models.FollowersProfile
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

/**
 * Created by Akash Verma on 18/03/18.
 */
interface ApiServiceHelper {

    @GET("{userName}/followers")
    fun getFollowers(@Path("userName") userName: String): Observable<ArrayList<FollowersProfile>>
}

