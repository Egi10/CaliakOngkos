package id.buaja.egifcb.caliakongkos.network.model.city

import com.google.gson.annotations.SerializedName

data class Rajaongkir(

	@field:SerializedName("query")
	val query: Query? = null,

	@field:SerializedName("results")
	val results: ArrayList<ResultsItemCity>? = null,

	@field:SerializedName("status")
	val status: Status? = null
)