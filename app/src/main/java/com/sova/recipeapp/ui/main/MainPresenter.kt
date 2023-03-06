package com.sova.recipeapp.ui.main

import kotlinx.coroutines.*
import com.sova.recipeapp.network.NetworkService
import com.sova.recipeapp.ui.base.BasePresenter

class MainPresenter: BasePresenter<MainContract.View>, MainContract.Presenter {

    var view: MainContract.View? = null
    private val dataSource = NetworkService.create()
    private val job = SupervisorJob()
    private val scope = CoroutineScope(job + Dispatchers.Main)

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

    override fun getDataRecipeRandom() {
        scope.launch {
            view?.showProgress()
            try {
                val data = dataSource.getRandomRecipe()
                val response = data.await()
                view?.onRandomRecipeResponse(response)
                view?.hideProgress()
            }catch (throwable: Throwable){
                view?.onRandomRecipeFailure(throwable)
                view?.hideProgress()
            }
        }
    }

    override fun getDataCategory() {
        scope.launch {
            view?.showProgress()
            try {
                val data = dataSource.getCategoriesRecipe()
                val response = data.await()
                view?.onCategoryResponse(response)
                view?.hideProgress()
            }catch (throwable: Throwable){
                view?.onCategoryFailure(throwable)
                view?.hideProgress()
            }
        }
    }
}