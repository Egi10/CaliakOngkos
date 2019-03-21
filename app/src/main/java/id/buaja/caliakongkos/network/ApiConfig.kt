package id.buaja.caliakongkos.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object {
        fun config(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor {
                    val original = it.request()
                    val builder = original.newBuilder()
                        .addHeader("key", "556c47c70f5973c2c0ce647ef3def6ef")
                    val request = builder.build()

                    return@addInterceptor it.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.rajaongkir.com/starter/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}