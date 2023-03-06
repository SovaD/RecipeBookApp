package com.sova.recipeapp.ui.main

import com.sova.recipeapp.model.CategoryResponse
import com.sova.recipeapp.model.RecipeResponse
import com.sova.recipeapp.ui.base.BasePresenter
import com.sova.recipeapp.ui.base.BaseView

interface MainContract {
    interface View : BaseView<Presenter>{
        fun onRandomRecipeResponse(data: RecipeResponse)
        fun onRandomRecipeFailure(throwable: Throwable)

        fun onCategoryResponse(data: CategoryResponse)
        fun onCategoryFailure(throwable: Throwable)

    }

    interface Presenter: BasePresenter<View>{
        fun getDataRecipeRandom()
        fun getDataCategory()
    }
}