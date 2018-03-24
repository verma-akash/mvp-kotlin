package com.gravity.rxapplication.ui.mainactivity

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.EditText
import com.gravity.rxapplication.BaseActivity
import com.gravity.rxapplication.R
import com.gravity.rxapplication.models.FollowersProfile
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class MainActivity : BaseActivity(), MainActivityView {

    @Inject
    lateinit var profileAdapter: ProfileAdapter

    private val followersProfileArrayList = ArrayList<FollowersProfile>()

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)

        mainActivityPresenter.onAttach(this)

        profileAdapter.setFollowersProfileArrayList(followersProfileArrayList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = profileAdapter

        showDialog()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        mainContainer.visibility = View.GONE
        errorMsg.visibility = View.GONE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        mainActivityPresenter.onDetach()
        super.onDestroy()
    }

    private fun showDialog() {
        val li = LayoutInflater.from(this)
        val promptsView = li.inflate(R.layout.user_dialog, null)

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(promptsView)
        val userInput = promptsView.findViewById(R.id.user_name_et) as EditText

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK"
                ) { _, _ ->
                    mainActivityPresenter.loadFollowers(userInput.text.toString())
                }
                .setNegativeButton("Cancel"
                ) { dialog, _ -> dialog.cancel() }

        val alertDialog = alertDialogBuilder.create()

        alertDialog.show()
    }

    override fun initializeData(followersProfileArrayList: ArrayList<FollowersProfile>) {
        mainContainer.visibility = View.VISIBLE
        errorMsg.visibility = View.GONE
        this.followersProfileArrayList.clear()
        this.followersProfileArrayList.addAll(followersProfileArrayList)
        profileAdapter.notifyDataSetChanged()
    }

    override fun showErrorMsg() {
        mainContainer.visibility = View.GONE
        errorMsg.visibility = View.VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.change_user -> {
                showDialog()
                true
            }
            else -> {
                false
            }
        }
    }
}
