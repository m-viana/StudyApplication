package com.example.studyapplication.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import com.example.studyapplication.R

class CustomToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.style.CustomToolBar
) : Toolbar(context, attrs, defStyleAttr) {

    protected val textTitle: AppCompatTextView
    var defaultButtonListener: ButtonListener? = null

    init {
        super.setTitle(null)
        LayoutInflater.from(context).inflate(R.layout.custom_toolbar, this)
        setPadding(0, 0, 0, 0)
        setContentInsetsAbsolute(0, 0)

        textTitle = findViewById(R.id.toolbar_title)
    }

    override fun setTitle(@StringRes resId: Int) {
        textTitle.setText(resId)
    }

    override fun setTitle(title: CharSequence?) {
        textTitle.text = title
    }

    @JvmOverloads
    fun showBackButton(listener: (() -> Unit)? = null) {
        setNavigationIcon(R.drawable.ic_back)
        setNavigationOnClickListener {
            listener?.let { it() }
                ?: run { defaultButtonListener?.onBackPressed() }
        }
    }

    fun setupBackButton(@DrawableRes icon: Int, action: () -> Unit) {
        setNavigationIcon(icon)
        setNavigationOnClickListener {
            action()
        }
    }

    fun hideBackButton() {
        navigationIcon = null
        setNavigationOnClickListener(null)
    }

    fun setMenu(@MenuRes menu: Int,
                listener: OnMenuItemClickListener
    ) {
        clearMenu()
        inflateMenu(menu)
        setOnMenuItemClickListener(listener)
    }

    fun clearMenu() {
        menu?.clear()
    }

    interface ButtonListener {
        fun onBackPressed()
    }
}