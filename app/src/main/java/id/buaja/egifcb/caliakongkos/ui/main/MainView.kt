package id.buaja.egifcb.caliakongkos.ui.main

import id.buaja.egifcb.caliakongkos.base.BaseView
import id.buaja.egifcb.caliakongkos.network.model.province.Rajaongkir

interface MainView : BaseView {
    fun onSuccess(rajaOngkir: Rajaongkir?)
    fun onFailed(message: String?)
    fun onError(error: String?)
}