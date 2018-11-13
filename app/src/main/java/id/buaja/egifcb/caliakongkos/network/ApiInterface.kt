package id.buaja.egifcb.caliakongkos.network

import id.buaja.egifcb.caliakongkos.network.model.province.ResponseProvince
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("province")
    fun getProvice(): Call<ResponseProvince>
}