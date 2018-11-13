package id.buaja.egifcb.caliakongkos.network.model.province

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("province_id")
	val provinceId: String? = null
)