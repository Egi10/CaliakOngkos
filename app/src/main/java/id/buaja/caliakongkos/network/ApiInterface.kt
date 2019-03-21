package id.buaja.caliakongkos.network

import id.buaja.caliakongkos.network.model.city.ResponseCity
import id.buaja.caliakongkos.network.model.cost.ResponseCost
import id.buaja.caliakongkos.network.model.province.ResponseProvince
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("province")
    fun getProvice(): Call<ResponseProvince>

    @GET("city")
    fun getCity(@Query("province") id: String?): Call<ResponseCity>

    @FormUrlEncoded
    @POST("cost")
    fun checkCost(@Field("origin") origin: String?,
                  @Field("destination") destination: String?,
                  @Field("weight") weight: String?,
                  @Field("courier") courier: String?): Call<ResponseCost>
}