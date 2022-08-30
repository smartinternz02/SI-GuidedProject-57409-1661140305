
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val data = DataSource.dogs
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogImage : ImageView = view!!.findViewById(R.id.dog_image)
        val dogName : TextView = view!!.findViewById(R.id.dog_name)
        val dogAge : TextView = view!!.findViewById(R.id.dog_age)
        val dogHobby : TextView = view!!.findViewById(R.id.dog_hobby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val adapterLayout = when(layout){
            Layout.VERTICAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }

            Layout.HORIZONTAL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }

            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.grid_list_item, parent, false)
            }
        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val resources = context?.resources

        val dogItem = data[position]
        holder.dogImage.setImageResource(dogItem.imageResourceId)
        holder.dogName.text = dogItem.name
        holder.dogAge.text = resources?.getString(R.string.dog_age , dogItem.age)
        holder.dogHobby.text = resources?.getString(R.string.dog_hobbies , dogItem.hobbies)
    }
}
