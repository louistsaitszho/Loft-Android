package io.github.louistsaitszho.loft

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import io.github.louistsaitszho.loft.common.navigationDelegate.NavigationDelegate
import io.github.louistsaitszho.loft.common.navigationDelegate.Transition

/**
 * This is the one and only activity in the app. Everything lives on Fragments, navigation via the
 * Navigation AAC, and this is the activity that hosts all of them.
 *
 * Other notes:
 * - I don't think I need to care about onSaveInstanceState here (at least for now)
 */
class TheMostImportantActivity : AppCompatActivity(), NavigationDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_most_important)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()

    override fun navigate(transition: Transition) {
        val actionId = when (transition) {
            is Transition.WhatIs2Enter -> R.id.action_whatIsLoftFragment_to_enterLoftFragment
            is Transition.Enter2Creation -> R.id.action_enterLoftFragment_to_creationFragment
            is Transition.Enter2Joining -> R.id.action_enterLoftFragment_to_joiningFragment
            is Transition.Joining2WaitForConfirmation ->
                R.id.action_joiningFragment_to_waitForConfirmationFragment
            is Transition.Creation2Main -> R.id.action_creationFragment_to_mainFragment
        }
        findNavController(R.id.nav_host_fragment).navigate(actionId)
    }
}
