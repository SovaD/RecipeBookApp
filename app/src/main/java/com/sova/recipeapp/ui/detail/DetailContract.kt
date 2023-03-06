package com.sova.recipeapp.ui.detail

import com.sova.recipeapp.model.Recipe
import com.sova.recipeapp.model.RecipeResponse
import com.sova.recipeapp.ui.base.BasePresenter
import com.sova.recipeapp.ui.base.BaseView

interface DetailContract {
    interface View: BaseView<Presenter>{
        fun onDataDetailResponse(data: RecipeResponse)
        fun onDataDetailFailure(throwable: Throwable)

    }

    interface Presenter: BasePresenter<View>{
        fun getDataDetailRecipe(idMeal: String?)
    }
}