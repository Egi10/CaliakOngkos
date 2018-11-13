package id.buaja.egifcb.caliakongkos.ui.cost

import id.buaja.egifcb.caliakongkos.base.BaseView
import id.buaja.egifcb.caliakongkos.network.model.cost.ResultsItem

interface CostView : BaseView {
    fun onSuccess(list: List<ResultsItem>?)
    fun onFailed(message: String?)
    fun onError(error: String?)
}