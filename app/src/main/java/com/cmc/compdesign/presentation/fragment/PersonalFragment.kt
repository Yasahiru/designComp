package com.cmc.compdesign.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cmc.compdesign.R
import com.cmc.compdesign.presentation.viewmodel.RegistrationViewModel


class PersonalFragment : Fragment(R.layout.fragment_personal) {

    private lateinit var viewModel: RegistrationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[RegistrationViewModel::class.java]

        val pregnancyWeekEdit = view.findViewById<EditText>(R.id.editTextPregnancyWeek)
        val ageEdit = view.findViewById<EditText>(R.id.editTextAge)
        val spinnerFirstPregnancy = view.findViewById<Spinner>(R.id.spinnerFirstPregnancy)
        val nextBtn = view.findViewById<Button>(R.id.buttonNextPersonal)

        // Set up spinner options for first pregnancy
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.first_pregnancy_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFirstPregnancy.adapter = adapter

        nextBtn.setOnClickListener {
            val pregnancyWeek = pregnancyWeekEdit.text.toString()
            val age = ageEdit.text.toString()
            val firstPregnancy = spinnerFirstPregnancy.selectedItem.toString()

            viewModel.setPersonalInfo(pregnancyWeek, age, firstPregnancy)

            findNavController().navigate(R.id.action_personalFragment_to_babyFragment)
        }
    }
}
