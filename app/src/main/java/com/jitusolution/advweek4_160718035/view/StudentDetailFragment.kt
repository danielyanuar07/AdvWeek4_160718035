package com.jitusolution.advweek4_160718035.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jitusolution.advweek4_160718035.R
import com.jitusolution.advweek4_160718035.Util.loadImage
import com.jitusolution.advweek4_160718035.model.Student
import com.jitusolution.advweek4_160718035.viewmodel.DetailViewModel
import com.jitusolution.advweek4_160718035.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_detail.txtName
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val idS = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.fetch(idS);

        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            imageView2.loadImage(it.photoUrl.toString(),null)
            txtID.setText(it.id)
            txtName.setText(it.name)
            txtBod.setText(it.bod)
            txtPhone.setText(it.phone)


        })

    }

}