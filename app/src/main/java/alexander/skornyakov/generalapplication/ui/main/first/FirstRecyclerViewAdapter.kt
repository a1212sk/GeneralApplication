package alexander.skornyakov.generalapplication.ui.main.first

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.data.model.MainFirstModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView

class FirstRecyclerViewAdapter constructor(val data: List<MainFirstModel>)
    : RecyclerView.Adapter<FirstRecyclerViewAdapter.FirstViewHolder>(){

    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header = itemView.findViewById<TextView>(R.id.header)
        val text = itemView.findViewById<TextView>(R.id.text)
        val image = itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
       // TODO("BINDING")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.main_first_rv_item, parent, false)
        val viewHolder = FirstViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        val model = data.get(position)
        holder.header.text = model.header
        holder.text.text = model.text
        holder.image.setImageBitmap(model.image)
    }

}