package io.github.louistsaitszho.loft.joining

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.louistsaitszho.loft.onboarding.R
import kotlinx.android.synthetic.main.fragment_joining.*
import org.koin.android.viewmodel.ext.android.viewModel as viewModelLazily

class JoiningFragment : Fragment() {

    val viewModel: JoiningViewModel by viewModelLazily()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_joining, container, false)
        observeAllLiveData()
        return view
    }

    private fun observeAllLiveData() {
        //TODO
    }

    override fun onStart() {
        super.onStart()
        fab_join_loft_confirm.setOnClickListener {

        }
    }
}