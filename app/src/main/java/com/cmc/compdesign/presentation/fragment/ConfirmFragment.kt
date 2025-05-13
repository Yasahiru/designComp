package com.cmc.compdesign.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import com.cmc.compdesign.R

class ConfirmFragment : Fragment(R.layout.fragment_confirm) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkIcon = view.findViewById<ImageView>(R.id.imageViewCheckIcon)
        val successText = view.findViewById<TextView>(R.id.textViewVerifySuccessful)

        // You can trigger an animation or change text here if needed
        // For example, to change the icon color or animate the checkmark

        // Optionally, you can navigate to another fragment or activity after verification
        // For example:
        // findNavController().navigate(R.id.action_confirmFragment_to_homeFragment)
    }
}
