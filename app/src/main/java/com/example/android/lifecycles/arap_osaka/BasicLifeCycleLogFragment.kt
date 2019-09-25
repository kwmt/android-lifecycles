package com.example.android.lifecycles.arap_osaka

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.android.codelabs.lifecycle.R
import timber.log.Timber

class BasicLifeCycleLogFragment : Fragment() {

    interface OnClickTextView {
        fun onClick(text: String)
    }

    private var listener: OnClickTextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView: $savedInstanceState")
        return inflater.inflate(R.layout.fragment_basic_lifecycle, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach: context=${getContext()}, activity=$activity")
        listener = context as? OnClickTextView
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        Timber.d("onAttachFragment: context=$context, activity=$activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("onViewCreated: savedInstanceState=$savedInstanceState, context=$context, activity=$activity")
//        val baseTextView = view.findViewById<TextView>(R.id.base_text)
//        Timber.d("baseTextView: $baseTextView")
//
//        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
//        Timber.d("toobar: $toolbar")

//        val basic1TextView:TextView = view.findViewById<TextView>(R.id.basic1_text_view)
//        basic1TextView.setOnClickListener {
//            listener?.onClick((it as TextView).text as String)
//        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("onActivityCreated: savedInstanceState=$savedInstanceState, context=$context, activity=$activity")
        val baseTextView = requireParentFragment().view?.findViewById<TextView>(R.id.base_text)
        Timber.d("baseTextView: $baseTextView")
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.toolbar)
        Timber.d("toobar: $toolbar")
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
        outState.putString("testString", "TestStringValue")
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("onActivityResult requestCode=$resultCode, resultCode=$resultCode, data=$data")
    }
}
