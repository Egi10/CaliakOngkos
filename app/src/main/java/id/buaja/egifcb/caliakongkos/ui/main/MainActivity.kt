package id.buaja.egifcb.caliakongkos.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.buaja.egifcb.caliakongkos.R
import id.buaja.egifcb.caliakongkos.network.model.province.Rajaongkir

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter.getProvince()
    }

    override fun onSuccess(rajaOngkir: Rajaongkir?) {
        Toast.makeText(baseContext, rajaOngkir?.status?.description, Toast.LENGTH_LONG).show()
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
}
