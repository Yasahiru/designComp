package com.cmc.compdesign.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cmc.compdesign.R
import com.cmc.compdesign.presentation.viewmodel.RegistrationViewModel


class AccountFragment : Fragment(R.layout.fragment_account) {

    private lateinit var viewModel: RegistrationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[RegistrationViewModel::class.java]

        val nameEdit = view.findViewById<EditText>(R.id.editTextName)
        val emailEdit = view.findViewById<EditText>(R.id.editTextEmail)
        val passwordEdit = view.findViewById<EditText>(R.id.editTextPassword)
        val nextBtn = view.findViewById<Button>(R.id.buttonNextAccount)

        nextBtn.setOnClickListener {
            val name = nameEdit.text.toString()
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()

            viewModel.setAccountInfo(name, email, password)

            findNavController().navigate(R.id.action_accountFragment_to_personalFragment)
        }
    }
}
