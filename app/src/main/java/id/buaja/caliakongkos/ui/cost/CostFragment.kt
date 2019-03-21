package id.buaja.caliakongkos.ui.cost

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import id.buaja.caliakongkos.R
import id.buaja.caliakongkos.adapter.CostAdapter
import id.buaja.caliakongkos.network.model.cost.CostsItem
import id.buaja.caliakongkos.network.model.cost.ResultsItem
import kotlinx.android.synthetic.main.fragment_cost.*

class CostFragment : Fragment(), CostView {
    private var origin: String? = null
    private var destination: String? = null
    private var weight: String? = null
    private var courier: String? = null
    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"
    private val ARG_PARAM3 = "param3"
    private val ARG_PARAM4 = "param4"
    private lateinit var costPresenter: CostPresenter
    private lateinit var costAdapter: CostAdapter
    private var listCost: MutableList<CostsItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            origin = it.getString(ARG_PARAM1)
            destination = it.getString(ARG_PARAM2)
            weight = it.getString(ARG_PARAM3)
            courier = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        costPresenter = CostPresenter(this)
        costPresenter.getCost(origin, destination, weight, courier)

        swipeRefresh.post {
            loadData()
        }

        swipeRefresh.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        recyclerView.layoutManager = LinearLayoutManager(activity?.baseContext)
        costAdapter = CostAdapter(activity?.baseContext, listCost) {

        }
        recyclerView.adapter = costAdapter
    }

    override fun onSuccess(list: List<ResultsItem>?) {
        listCost.clear()
        list?.let {
            for (i in it.indices) {
                it[i].costs?.let { it1 ->
                    listCost.addAll(it1)
                }
            }
        }
        costAdapter.notifyDataSetChanged()
    }

    override fun onFailed(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String) = CostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}
