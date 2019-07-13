package com.example.grocer21

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

class HelpDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(R.string.help_dialog)
                .setNegativeButton(R.string.got_it) { _, _ ->
                    // User cancelled the dialog
                }
        // Create the AlertDialog object and return it
        return builder.create()
    }
}
