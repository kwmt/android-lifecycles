package com.example.android.lifecycles

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import timber.log.Timber
import java.io.PrintWriter
import java.io.StringWriter

val Throwable.stackTraceString: String
    get() {
        val stringWriter = StringWriter()
        this.printStackTrace(PrintWriter(stringWriter))
        return stringWriter.toString()
    }

abstract class LifeCycleLogFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach: context=${getContext()}, activity=$activity")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        Timber.d("onAttachFragment: context=$context, activity=$activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated: context=$context, activity=$activity")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated: context=$context, activity=$activity")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate: savedInstanceState=$savedInstanceState, context=$context, activity=$activity")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart: context=$context, activity=$activity")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume: context=$context, activity=$activity")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.d("onSaveInstanceState: context=$context, outState=$outState, activity=$activity")
    }

    override fun onPause() {
        Timber.d("onPause: context=$context, activity=$activity")
        super.onPause()
        Timber.d("onPause: after super.onPause context=$context, activity=$activity")
    }

    override fun onDetach() {
        Timber.d("onDetach: context=$context, activity=$activity")
        super.onDetach()
        Timber.d("onDetach: after super.onDetach context=$context, activity=$activity")
    }

    override fun onDestroyView() {
        Timber.d("onDestroyView: context=$context, activity=$activity")
        super.onDestroyView()
        Timber.d("onDestroyView: after super.onDestroyView context=$context, activity=$activity")
    }

    override fun onStop() {
        Timber.d("onStop: context=$context, activity=$activity")
        super.onStop()
        Timber.d("onStop: after super.onStop context=$context, activity=$activity")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.d("onViewStateRestored: savedInstanceState=$savedInstanceState, context=$context, activity=$activity")
    }

    override fun onDestroy() {
        Timber.d("onDestroy: context=$context, activity=$activity")
        super.onDestroy()
        Timber.d("onDestroy: after super.onDestroy context=$context, activity=$activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView: savedInstanceState=$savedInstanceState, context=$context, activity=$activity")

        return TextView(activity).apply {
            text = "hello world"
        }
    }
}
