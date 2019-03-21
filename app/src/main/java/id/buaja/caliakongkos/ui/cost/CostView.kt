package id.buaja.caliakongkos.ui.cost

import id.buaja.caliakongkos.base.BaseView
import id.buaja.caliakongkos.network.model.cost.ResultsItem

interface CostView : BaseView {
    fun onSuccess(list: List<ResultsItem>?)
    fun onFailed(message: String?)
    fun onError(error: String?)
}