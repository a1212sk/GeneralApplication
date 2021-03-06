package alexander.skornyakov.generalapplication.ui.main.second

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.data.model.MainSecondModel
import alexander.skornyakov.generalapplication.ui.main.second.ModelDiffCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SecondRecyclerViewAdapter
    : ListAdapter<MainSecondModel, SecondRecyclerViewAdapter.SecondViewHolder>(ModelDiffCallback()){

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }

    private lateinit var listener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    class SecondViewHolder(itemView: View, val listener: OnItemClickListener? = null)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val header = itemView.findViewById<TextView>(R.id.header)
        val text = itemView.findViewById<TextView>(R.id.text)
        val image = itemView.findViewById<ImageView>(R.id.image)
        init{
            itemView.findViewById<CardView>(R.id.first_card).setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener?.onItemClick(view!!,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.main_second_rv_item, parent, false)
        val viewHolder = SecondViewHolder(view, listener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val model = getItem(position)
        holder.apply {
            header.text = model.header
            text.text = model.text
            image.setImageBitmap(model.image)
        }
    }

}

class ModelDiffCallback : DiffUtil.ItemCallback<MainSecondModel>() {
    override fun areItemsTheSame(oldItem: MainSecondModel, newItem: MainSecondModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MainSecondModel, newItem: MainSecondModel): Boolean {
        return oldItem == newItem
    }

}