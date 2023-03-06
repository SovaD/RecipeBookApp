package com.sova.recipeapp.ui.base

interface BasePresenter<T> {

    fun takeView(view: T)

    fun dropView()
}