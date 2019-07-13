package com.example.grocer21

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AddNewFood.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class AddNewFood : Fragment() {

    private lateinit var mEditFoodUPCView: EditText
    private lateinit var mEditFoodNameView: EditText
    private var mListener: OnFragmentInteractionListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_new_food, container, false)

        mEditFoodNameView = view.findViewById(R.id.add_food_name_entry)
        mEditFoodUPCView = view.findViewById(R.id.add_food_upc_entry)
        val saveButton = view.findViewById<Button>(R.id.add_button)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)
        val extras = Bundle()

        saveButton.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(mEditFoodNameView.text)) {
                activity!!.setResult(RESULT_CANCELED, replyIntent)
            } else {
                val food = mEditFoodNameView.text.toString()
                val upc = java.lang.Long.parseLong(mEditFoodUPCView.text.toString())
                extras.putString("FOOD_NAME", food)
                extras.putLong("UPC_CODE", upc)
                replyIntent.putExtras(extras)
                activity!!.setResult(RESULT_OK, replyIntent)
            }
            activity!!.finish()
        }

        cancelButton.setOnClickListener {
            val replyIntent = Intent()
            activity!!.setResult(RESULT_CANCELED, replyIntent)
            activity!!.finish()
        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener
}// Required empty public constructor
