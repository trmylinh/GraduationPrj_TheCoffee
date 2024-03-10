package com.example.thecoffee.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.thecoffee.models.Category
import com.example.thecoffee.models.Drink
import com.example.thecoffee.repositories.ProductRepository

class ProductViewModel (application: Application) : AndroidViewModel(application) {
    private var repository: ProductRepository
    private var _categoryList = MutableLiveData<ArrayList<Category>>()
    private var _drinkList = MutableLiveData<ArrayList<Drink>>()
//    private val _loadingCategoryResult = MutableLiveData<Boolean>()
    private val _loadingDrinkResult: MutableLiveData<Boolean>
    private val _loadingCategoryResult: MutableLiveData<Boolean>
//    val loadingCategoryResult: MutableLiveData<Boolean>
//        get() = _loadingCategoryResult
    val loadingDrinkResult: MutableLiveData<Boolean>
        get() = _loadingDrinkResult

    val loadingCategoryResult: MutableLiveData<Boolean>
        get() = _loadingCategoryResult

    val getCategoryList : MutableLiveData<ArrayList<Category>>
        get() = _categoryList

    val getDrinkList : MutableLiveData<ArrayList<Drink>>
        get() = _drinkList

    init {
        repository = ProductRepository(application)
        _categoryList = repository.getCategoryList
        _drinkList = repository.getDrinkList
        _loadingDrinkResult = repository.loadingDrinkResult
        _loadingCategoryResult = repository.loadingCategoryResult
    }

    fun getDataCategoryList() {
        repository.getDataCategoryList()
    }

    fun getDataDrinkList(){
        repository.getDataDrink()
    }

}