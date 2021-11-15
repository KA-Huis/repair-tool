package com.example.repairtool

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repairtool.databinding.RecyclerviewItemBinding

class MainAdapter(private val jobList:List<Job>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val itemBinding:RecyclerviewItemBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
            fun bindItem(job:Job) {
                itemBinding.tvJob.text = job.job
                itemBinding.tvPlace.text = job.place
                itemBinding.tvStatus.append(job.status)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val job = jobList[position]
        holder.bindItem(job)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }
}