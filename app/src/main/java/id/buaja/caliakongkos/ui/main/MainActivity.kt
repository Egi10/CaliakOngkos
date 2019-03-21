package id.buaja.caliakongkos.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import id.buaja.caliakongkos.R
import id.buaja.caliakongkos.adapter.SpinnerCityAdapter
import id.buaja.caliakongkos.adapter.SpinnerProvinsiAdapter
import id.buaja.caliakongkos.network.model.city.ResultsItemCity
import id.buaja.caliakongkos.network.model.province.ResultsItem
import id.buaja.caliakongkos.ui.cost.CostFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), MainView, AdapterView.OnItemSelectedListener, View.OnClickListener {
    override fun onClick(v: View?) {
        weight = et_weight.text.toString()

        val fragment = CostFragment.newInstance(origin, destination, weight, courier)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private lateinit var mainPresenter: MainPresenter
    private lateinit var spinnerProvinceAdapter: SpinnerProvinsiAdapter
    private lateinit var spinnerCityAdapter: SpinnerCityAdapter
    private var listResult: MutableList<ResultsItem> = mutableListOf()
    private var listResultCity: MutableList<ResultsItemCity> = mutableListOf()
    private var listJasaKirim: ArrayList<String> = ArrayList()
    private lateinit var origin: String
    private lateinit var destination: String
    private lateinit var weight: String
    private lateinit var courier: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        loadData()

        spinnerProvinceAdapter = SpinnerProvinsiAdapter(baseContext, listResult)
        spinnerProvinsiAsal.adapter = spinnerProvinceAdapter
        spinnerProvinsiAsal.onItemSelectedListener = this

        spinnerProvinsiTujuan.adapter = spinnerProvinceAdapter
        spinnerProvinsiTujuan.onItemSelectedListener = this

        listJasaKirim.add("jne")
        listJasaKirim.add("tiki")
        listJasaKirim.add("pos")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listJasaKirim)
        spinnerJasaPengirim.adapter = adapter
        spinnerJasaPengirim.onItemSelectedListener = this

        tvCaliakOngkos.setOnClickListener(this)
    }

    private fun loadData() {
        mainPresenter.getProvince()
    }

    override fun onSuccessProvince(list: ArrayList<ResultsItem>?) {
        listResult.clear()
        list?.let {
            listResult.addAll(it)
        }
        spinnerProvinceAdapter.notifyDataSetChanged()
    }

    override fun onSuccessCity(list: ArrayList<ResultsItemCity>?) {
        listResultCity.clear()
        list?.let {
            listResultCity.addAll(it)
        }
        spinnerCityAdapter.notifyDataSetChanged()
    }

    override fun onFailed(message: String?) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    override fun onError(error: String?) {
        Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id) {
            R.id.spinnerProvinsiAsal -> {
                mainPresenter.getCity(listResult[position].provinceId)

                spinnerCityAdapter = SpinnerCityAdapter(baseContext, listResultCity)
                spinnerKabupatenAsal.adapter = spinnerCityAdapter
                spinnerKabupatenAsal.onItemSelectedListener = this
            }

            R.id.spinnerProvinsiTujuan -> {
                mainPresenter.getCity(listResult[position].provinceId)

                spinnerCityAdapter = SpinnerCityAdapter(baseContext, listResultCity)
                spinnerKabupatenTujuan.adapter = spinnerCityAdapter
                spinnerKabupatenTujuan.onItemSelectedListener = this
            }

            R.id.spinnerKabupatenAsal -> {
                origin = listResultCity[position].cityId.toString()
            }

            R.id.spinnerKabupatenTujuan -> {
                destination = listResultCity[position].cityId.toString()
            }

            R.id.spinnerJasaPengirim -> {
                val item = parent.getItemAtPosition(position)
                courier = item.toString()
            }
        }
    }
}
