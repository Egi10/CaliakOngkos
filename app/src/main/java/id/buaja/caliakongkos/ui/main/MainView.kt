package id.buaja.caliakongkos.ui.main

import id.buaja.caliakongkos.base.BaseView
import id.buaja.caliakongkos.network.model.city.ResultsItemCity
import id.buaja.caliakongkos.network.model.province.ResultsItem

interface MainView : BaseView {
    fun onSuccessProvince(list: ArrayList<ResultsItem>?)
    fun onSuccessCity(list: ArrayList<ResultsItemCity>?)
    fun onFailed(message: String?)
    fun onError(error: String?)
}