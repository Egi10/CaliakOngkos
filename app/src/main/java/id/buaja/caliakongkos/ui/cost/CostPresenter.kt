package id.buaja.caliakongkos.ui.cost

import id.buaja.caliakongkos.network.ApiConfig
import id.buaja.caliakongkos.network.model.cost.ResponseCost
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CostPresenter(private val view: CostView) {
    fun getCost(origin: String?, destination: String?, weight: String?, courier: String?) {
        view.showLoading()

        val config = ApiConfig.config()
        val call = config.checkCost(origin, destination, weight, courier)
        call.enqueue(object : Callback<ResponseCost> {
            override fun onFailure(call: Call<ResponseCost>, t: Throwable) {
                view.onError(t.message)
                view.hideLoading()
            }

            override fun onResponse(call: Call<ResponseCost>, response: Response<ResponseCost>) {
                when (response.code()) {
                    200 -> {
                        view.onSuccess(response.body()?.rajaongkir?.results)
                    }

                    400 -> {
                        val jsonObjects = JSONObject(response.errorBody()?.string())
                        view.onFailed(jsonObjects.getJSONObject("rajaongkir").getJSONObject("status").getString("description"))
                    }
                }

                view.hideLoading()
            }

        })
    }
}