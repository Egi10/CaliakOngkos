package id.buaja.egifcb.caliakongkos.network.model.province

import com.google.gson.annotations.SerializedName

data class Rajaongkir(

	@field:SerializedName("query")
	val query: List<Any?>? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("status")
	val status: Status? = null
)