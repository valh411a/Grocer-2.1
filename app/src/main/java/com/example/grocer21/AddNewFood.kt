package com.example.grocer21

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AddNewFood.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class AddNewFood : Fragment() {

    private lateinit var mEditFoodUPCView: EditText
    private lateinit var mEditFoodNameView: EditText
    private var mListener: OnSaveButtonPressedListener? = null
    internal lateinit var callback: OnSaveButtonPressedListener

    fun setOnSaveButtonPressedListener(callback: OnSaveButtonPressedListener) {
        this.callback = callback
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_new_food, container, false)

        mEditFoodNameView = view.findViewById(R.id.add_food_name_entry)
        mEditFoodUPCView = view.findViewById(R.id.add_food_upc_entry)
        val saveButton = view.findViewById<Button>(R.id.add_button)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)
        var buttonPressed: String
        val extras = Bundle()

        saveButton.setOnClickListener {
            buttonPressed = "save"
            extras.putString("button pressed", buttonPressed)
            if (mEditFoodNameView.text.toString() != "" && mEditFoodUPCView.text.toString() != "") {
                extras.putString("name", mEditFoodNameView.text.toString())
                extras.putLong("upc", mEditFoodUPCView.text.toString().toLong())
                callback.onNewFoodSaved(extras)
            } else {
                Toast.makeText(view.context, "You cannot add empty foods. Press cancel to go back.", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            buttonPressed = "cancel"
            extras.putString("button pressed", buttonPressed)
            activity?.supportFragmentManager?.popBackStack()

        }

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnSaveButtonPressedListener) {
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
    interface OnSaveButtonPressedListener {
        fun onNewFoodSaved(position: Bundle) {

        }

    }
}// Required empty public constructor
