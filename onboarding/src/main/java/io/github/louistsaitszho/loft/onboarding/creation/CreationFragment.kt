package io.github.louistsaitszho.loft.onboarding.creation

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import io.github.louistsaitszho.loft.common.navigationDelegate.NavigationFragment
import io.github.louistsaitszho.loft.common.navigationDelegate.Transition
import io.github.louistsaitszho.loft.common.utils.getInputText
import io.github.louistsaitszho.loft.common.utils.hideSoftKeyboard
import io.github.louistsaitszho.loft.common.utils.showSoftKeyboardAndFocus
import io.github.louistsaitszho.loft.onboarding.R
import kotlinx.android.synthetic.main.fragment_creation.*
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class CreationFragment : NavigationFragment() {

    private val viewModel: CreationViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_creation, container, false)
        subscribeToAllLiveData()
        return view
    }

    private fun subscribeToAllLiveData() {
        viewModel.keyboardFocusLiveData.observe(this, Observer { keyboardFocus ->
            when (keyboardFocus) {
                CreationViewModel.KeyboardFocus.LOFT_NAME ->
                    edit_text_loft_name.showSoftKeyboardAndFocus()
                CreationViewModel.KeyboardFocus.USER_NAME ->
                    edit_text_your_name.showSoftKeyboardAndFocus()
                null -> hideSoftKeyboard()
            }
        })
        viewModel.formErrorLiveData.observe(this, Observer {
            when (it) {
                CreationViewModel.CreationFormError.BLANK_LOFT_NAME ->
                    edit_text_loft_name.error = "Loft name cannot be blank"
                CreationViewModel.CreationFormError.BLANK_USER_NAME ->
                    edit_text_your_name.error = "Your name cannot be blank"
                null -> {
                    edit_text_loft_name.error = null
                    edit_text_your_name.error = null
                }
            }
        })
        viewModel.nextSceneLiveData.observe(this, Observer {
            if (it == CreationViewModel.NextScene.MAIN) {
                navigationDelegate?.navigate(Transition.Creation2Main())
            }
        })
    }

    override fun onStart() {
        super.onStart()
        fab_create_loft_confirm.setOnClickListener {
            viewModel.createLoft(
                    loftName = edit_text_loft_name.getInputText(),
                    yourName = edit_text_your_name.getInputText()
            )
        }
        edit_text_your_name.setOnEditorActionListener { _, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEND -> fab_create_loft_confirm.performClick()
                else -> false
            }
        }
    }
}
