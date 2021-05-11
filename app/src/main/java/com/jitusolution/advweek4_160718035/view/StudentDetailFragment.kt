package com.jitusolution.advweek4_160718035.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jitusolution.advweek4_160718035.R
import com.jitusolution.advweek4_160718035.Util.loadImage
import com.jitusolution.advweek4_160718035.databinding.FragmentStudentDetailBinding
import com.jitusolution.advweek4_160718035.model.Student
import com.jitusolution.advweek4_160718035.viewmodel.DetailViewModel
import com.jitusolution.advweek4_160718035.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_detail.txtName
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(),ButtonNotifClickListener{

    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater,R.layout.fragment_student_detail,container,false)

        return dataBinding.root //inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val idS = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.fetch(idS);

        dataBinding.listener= this
        observeViewModel()

    }

    override fun onButtonNotifClick(v: View) {
        Observable.timer(2,TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{
                            MainActivity.showNotification(v.tag.toString(),
                                    "New Notifications Creator",
                                    R.drawable.ic_baseline_person_24)
                        }
    }
    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student =it
//
//            imageView2.loadImage(it.photoUrl.toString(),null)
//            txtID.setText(it.id)
//            txtName.setText(it.name)
//            txtBod.setText(it.bod)
//            txtPhone.setText(it.phone)
//            var student = it
//            btnNotif.setOnClickListener {
//                Observable.timer(5,TimeUnit.SECONDS)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe{
//                            MainActivity.showNotification(student.name.toString(),
//                                    "New Notifications Creator",
//                                    R.drawable.ic_baseline_person_24)
//                        }
//            }
        })

    }

}