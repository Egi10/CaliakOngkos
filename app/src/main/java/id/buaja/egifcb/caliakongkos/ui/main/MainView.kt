package id.buaja.egifcb.caliakongkos.ui.main

import id.buaja.egifcb.caliakongkos.base.BaseView
import id.buaja.egifcb.caliakongkos.network.model.city.ResultsItemCity
import id.buaja.egifcb.caliakongkos.network.model.province.ResultsItem

interface MainView : BaseView {
    fun onSuccessProvince(list: ArrayList<ResultsItem>?)
    fun onSuccessCity(list: ArrayList<ResultsItemCity>?)
    fun onFailed(message: String?)
    fun onError(error: String?)
}