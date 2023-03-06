package com.sova.recipeapp.ui.category

import com.sova.recipeapp.model.FilterResponse
import com.sova.recipeapp.ui.base.BasePresenter
import com.sova.recipeapp.ui.base.BaseView

interface CategoryContract {
    interface View: BaseView<Presenter>{
        fun onDataCategoryResponse(data: FilterResponse)
        fun onDataCategoryFailure(throwable: Throwable)
    }

    interface Presenter: BasePresenter<View>{
        fun getDataByCategory(category: String?)
    }
}