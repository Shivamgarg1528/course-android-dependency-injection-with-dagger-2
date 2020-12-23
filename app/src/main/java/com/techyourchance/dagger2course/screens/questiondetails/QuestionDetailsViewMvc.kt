package com.techyourchance.dagger2course.screens.questiondetails

import android.text.Spanned
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.BaseViewMvc
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.layout_question_details
) {
    private val toolbar: MyToolbar
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView

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

    interface Listener {
        fun onNavigationUp()
    }
}