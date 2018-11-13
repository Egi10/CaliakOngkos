package id.buaja.egifcb.caliakongkos.ui.main

import id.buaja.egifcb.caliakongkos.network.ApiConfig
import id.buaja.egifcb.caliakongkos.network.model.province.ResponseProvince
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView) {
    fun getProvince() {
        view.showLoading()

        val config = ApiConfig.config()
        val call = config.getProvice()
        call.enqueue(object : Callback<ResponseProvince> {
            override fun onFailure(call: Call<ResponseProvince>, t: Throwable) {
                view.onError(t.message)
                view.hideLoading()
            }

            override fun onResponse(call: Call<ResponseProvince>, response: Response<ResponseProvince>) {
                when(response.code()) {
                    200 -> {
                        view.onSuccess(response.body()?.rajaongkir)
                    }

                    400 -> {
                        val jsonObjects = JSONObject(response.errorBody()?.string())
                        view.onFailed(jsonObjects.getString("description"))
                    }
                }

                view.hideLoading()
            }

        })
    }
}