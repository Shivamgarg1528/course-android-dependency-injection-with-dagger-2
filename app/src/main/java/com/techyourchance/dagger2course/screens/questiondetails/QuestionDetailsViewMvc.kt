package com.techyourchance.dagger2course.screens.questiondetails

import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(layoutInflater: LayoutInflater, parent: ViewGroup?) {

    interface Listener {
        fun onNavigationUp()
    }

    val rootView: View = layoutInflater.inflate(R.layout.layout_question_details, parent, false)

    private val toolbar: MyToolbar
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView

    private val mListeners = HashSet<Listener>()

    init {
        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            mListeners.forEach {
                it.onNavigationUp()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    fun setBodyText(spanned: Spanned) {
        txtQuestionBody.text = spanned
    }

    fun addListener(listener: Listener) {
        mListeners.add(listener)
    }

    fun removeListener(listener: Listener) {
        mListeners.remove(listener)
    }

    private fun <T : View?> findViewById(@IdRes resId: Int): T {
        return rootView.findViewById<T>(resId)
    }
}