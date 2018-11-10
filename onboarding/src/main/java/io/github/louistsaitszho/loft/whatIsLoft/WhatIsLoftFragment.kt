package io.github.louistsaitszho.loft.whatIsLoft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.common.NavigationFragment
import io.github.louistsaitszho.loft.common.Transition
import kotlinx.android.synthetic.main.fragment_what_is_loft.*

class WhatIsLoftFragment : NavigationFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_what_is_loft, container, false)
    }

    override fun onResume() {
        super.onResume()
        fab_next.setOnClickListener {
            navigationDelegate?.navigate(Transition.WhatIsToEnter())
        }
    }
}