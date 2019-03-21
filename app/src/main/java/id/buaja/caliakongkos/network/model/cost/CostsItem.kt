package id.buaja.caliakongkos.network.model.cost

import com.google.gson.annotations.SerializedName

data class CostsItem(

	@field:SerializedName("cost")
	val cost: List<CostItem>? = null,

	@field:SerializedName("service")
	val service: String? = null,

	@field:SerializedName("description")
	val description: String? = null
)