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

    interface OnItemClickListener{
        fun onItemClick(view: View, position: Int)
    }

    private lateinit var listener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    class FirstViewHolder(itemView: View, val listener: OnItemClickListener? = null)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val header = itemView.findViewById<TextView>(R.id.header)
        val text = itemView.findViewById<TextView>(R.id.text)
        val image = itemView.findViewById<ImageView>(R.id.image)
        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener?.onItemClick(view!!,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
       // TODO("BINDING")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.main_first_rv_item, parent, false)
        val viewHolder = FirstViewHolder(view, listener)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        val model = data.get(position)
        holder.apply {
            header.text = model.header
            text.text = model.text
            image.setImageBitmap(model.image)
        }
    }

}