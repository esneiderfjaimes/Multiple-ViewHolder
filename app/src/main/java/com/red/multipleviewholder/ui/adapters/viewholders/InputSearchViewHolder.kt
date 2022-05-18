package com.red.multipleviewholder.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.red.multipleviewholder.R
import com.red.multipleviewholder.model.Properties
import com.red.multipleviewholder.model.getString

class InputSearchViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val searchTextField = v.findViewById<TextInputLayout>(R.id.textField)

    fun bind(prop: Properties?) {
        prop?.getString("hint")?.let {
            searchTextField.hint = it
        }
    }

}