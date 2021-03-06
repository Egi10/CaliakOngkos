package id.buaja.caliakongkos.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import id.buaja.caliakongkos.R
import id.buaja.caliakongkos.network.model.city.ResultsItemCity

class SpinnerCityAdapter(private val context: Context?, private val list: List<ResultsItemCity>) : BaseAdapter() {
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, view: View?, p2: ViewGroup?): View {
        val layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewHolder = layoutInflater.inflate(R.layout.layout_spinner_adapter, null)

        val name = viewHolder.findViewById<TextView>(R.id.tv_name)
        name.text = list[p0].cityName

        return viewHolder
    }

    override fun getItem(p0: Int): Any? {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}