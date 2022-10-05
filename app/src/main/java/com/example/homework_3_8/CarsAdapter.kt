package com.example.homework_3_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3_8.databinding.ItemCarBinding

class CarsAdapter(
    val carList: ArrayList<Car>,
    val onClick:(position: Int) -> Unit
): RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {


    inner class CarsViewHolder(private val binding: ItemCarBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val car = carList[adapterPosition]
            binding.name.text = car.name
            binding.img.loadImage(car.image)
            binding.description.text = car.description
            binding.img.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        return CarsViewHolder(ItemCarBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = carList.size
}