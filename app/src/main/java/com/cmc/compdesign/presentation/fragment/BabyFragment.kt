package com.cmc.compdesign.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cmc.compdesign.R
import com.cmc.compdesign.presentation.viewmodel.RegistrationViewModel

class BabyFragment : Fragment(R.layout.fragment_baby) {

    private lateinit var viewModel: RegistrationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[RegistrationViewModel::class.java]

        val babyGenderSpinner = view.findViewById<Spinner>(R.id.spinnerBabyGender)
        val medicationsEdit = view.findViewById<EditText>(R.id.editTextMedications)
        val healthStatusEdit = view.findViewById<EditText>(R.id.editTextHealthStatus)
        val nextBtn = view.findViewById<Button>(R.id.buttonNextBaby)

        // Set up gender options
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.baby_gender_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        babyGenderSpinner.adapter = adapter

        nextBtn.setOnClickListener {
            val gender = babyGenderSpinner.selectedItem.toString()
            val medications = medicationsEdit.text.toString()
            val healthStatus = healthStatusEdit.text.toString()

            viewModel.setBabyInfo(gender, medications, healthStatus)

            findNavController().navigate(R.id.action_babyFragment_to_confirmFragment)
        }
    }
}
