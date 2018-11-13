package id.buaja.egifcb.caliakongkos.network.model.cost

import com.google.gson.annotations.SerializedName

data class CostItem(

	@field:SerializedName("note")
	val note: String? = null,

	@field:SerializedName("etd")
	val etd: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)