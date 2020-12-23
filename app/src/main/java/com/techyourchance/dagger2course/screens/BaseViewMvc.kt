package com.techyourchance.dagger2course.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

open class BaseViewMvc<LISTENER>(layoutInflater: LayoutInflater, parent: ViewGroup?, @LayoutRes layoutResId: Int) {

    val mRootView: View = layoutInflater.inflate(layoutResId, parent, false)

    protected val mContext: Context
        get() = mRootView.context

    // subscriptions
    val mListeners = HashSet<LISTENER>()

    fun addListener(listener: LISTENER) {
        mListeners.add(listener)
    }

    fun removeListener(listener: LISTENER) {
        mListeners.remove(listener)
    }

    protected fun <T : View?> findViewById(@IdRes resId: Int): T {
        return mRootView.findViewById<T>(resId)
    }
}