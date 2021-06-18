package com.example.studyapplication.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.studyapplication.R
import com.example.studyapplication.databinding.ProgressButtonBinding

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var loadingTitle: String? = null

    private val binding = ProgressButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    private var state: ProgressButtonState = ProgressButtonState.Normal
    set(value){
        field = value
        refreshState()
    }

    init {
        setLayout(attrs)
        refreshState()
    }

    private fun setLayout(attrs: AttributeSet?){
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressButton
            )

            setBackgroundResource(R.drawable.progress_button_background)

            /**Aqui é onde eu pego os valores do usuário, e vinculo com o componente**/
            val titleResId = attributes.getResourceId(R.styleable.ProgressButton_progress_button_title, 0)
            if (titleResId != 0){
                title = context.getString(titleResId)
            }

            val loadingTitleResId = attributes.getResourceId(R.styleable.ProgressButton_progress_button_loading_title, 0)
            if (loadingTitleResId != 0){
                loadingTitle = context.getString(loadingTitleResId)
            }

            attributes.recycle()
        }
    }
    private fun refreshState(){
        /**Aqui e no binding estamos falando que o botão vao começar com o estado normal e vai ser
         * clicavel**/
        isEnabled = state.isEnable
        isClickable = state.isEnable
        refreshDrawableState() /** Faz com que o selector selecione a forma correta do botão **/

        binding.textTitleButton.run{
            isEnabled = state.isEnable
            isClickable = state.isEnable
        }

        /** Aqui fala q a visibilidade dele vai ser de acordo com a visibilidade da sealed class **/
        binding.progressButton.visibility = state.progressVisibility

        when(state){
            ProgressButtonState.Normal -> binding.textTitleButton.text = title
            ProgressButtonState.Loading -> binding.textTitleButton.text = loadingTitle
        }
    }

    fun setLoading(){
        state = ProgressButtonState.Loading
    }

    fun setNormal(){
        state = ProgressButtonState.Normal
    }

    sealed class ProgressButtonState(val isEnable: Boolean, val progressVisibility: Int){
        object Normal: ProgressButtonState(true, View.GONE)
        object Loading: ProgressButtonState(false, View.VISIBLE)
    }
}