package com.jitusolution.advweek4_160718035.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.advweek4_160718035.R
import com.jitusolution.advweek4_160718035.Util.loadImage
import com.jitusolution.advweek4_160718035.databinding.StudentListItemBinding
import com.jitusolution.advweek4_160718035.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),ButtonDetailClickListener
    {
    class StudentViewHolder(var view:StudentListItemBinding): RecyclerView.ViewHolder(view.root)

    fun updateStudentList(newStudentList:List<Student>){
        studentList.clear();
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
        //1.01.58
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater,R.layout.student_list_item,parent,false)

        return StudentViewHolder(view)
        //55.20
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this
//        holder.view.txtId.text = studentList[position].id
//        holder.view.txtName.text = studentList[position].name
//        holder.view.imageView.loadImage(studentList[position].photoUrl.toString(),holder.view.progressBar)
//
//        holder.view.btnDetail.setOnClickListener {
//            var id:String = studentList[position].id.toString()
//            val action = StudentListFragmentDirections.actionStudentDetail(id)
//            Navigation.findNavController(it).navigate(action)
//        }
    }

        override fun onButtonDetailClick(v: View) {
            var id:String = v.tag.toString()//studentList[position].id.toString()
            val action = StudentListFragmentDirections.actionStudentDetail(id)
            Navigation.findNavController(v).navigate(action)
        }

    override fun getItemCount(): Int {
        return studentList.size
    }
}