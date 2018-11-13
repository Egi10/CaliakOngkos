package id.buaja.egifcb.caliakongkos.network.model.cost

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("costs")
	val costs: List<CostsItem>? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)