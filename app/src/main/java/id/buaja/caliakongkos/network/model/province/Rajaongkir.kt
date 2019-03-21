package id.buaja.caliakongkos.network.model.province

import com.google.gson.annotations.SerializedName

data class Rajaongkir(

	@field:SerializedName("query")
	val query: List<Any?>? = null,

	@field:SerializedName("results")
	val results: ArrayList<ResultsItem>?,

	@field:SerializedName("status")
	val status: Status? = null
)