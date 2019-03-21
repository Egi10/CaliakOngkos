package id.buaja.caliakongkos.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.buaja.caliakongkos.R
import id.buaja.caliakongkos.network.model.cost.CostsItem
import kotlinx.android.synthetic.main.layout_cost_adapter.view.*

class CostAdapter(private val context: Context?, private val list: List<CostsItem>, private val listener: (CostsItem) -> Unit)
    : RecyclerView.Adapter<CostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CostAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_cost_adapter, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        context?.let { holder.bindItem(list[position], listener, it) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(resultsItem: CostsItem, listener: (CostsItem) -> Unit, context: Context) {
            itemView.tv_name.text = resultsItem.description

            resultsItem.cost?.let {
                for (i in it.indices) {
                    itemView.tv_value.text = context.getString(R.string.value, it[i].value.toString())
                    itemView.tv_etd.text = context.getString(R.string.etd, it[i].etd.toString())
                }
            }

            itemView.setOnClickListener {
                listener(resultsItem)
            }
        }
    }
}