package com.sova.recipeapp.ui.search

import com.sova.recipeapp.model.FilterResponse
import com.sova.recipeapp.ui.base.BasePresenter
import com.sova.recipeapp.ui.base.BaseView

interface SearchContract {
    interface View: BaseView<Presenter>{
        fun onDataSearchResponse(data: FilterResponse)
        fun onDataSearchFailure(throwable: Throwable)
    }

    interface Presenter: BasePresenter<View>{
        fun getDataSearch(search: String?)
    }
}