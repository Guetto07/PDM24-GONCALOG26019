package com.example.appnoticias.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnoticias.data.remote.api.RetrofitInstance
import com.example.appnoticias.data.repository.RepositorioNoticiasIMPL
import com.example.appnoticias.domain.model.Noticias
import com.example.appnoticias.domain.use_case.ObterNoticiasUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ObterNoticiasViewModel : ViewModel() {
    private val api = RetrofitInstance.api
    private val repositorio = RepositorioNoticiasIMPL(api)
    private val ObterNoticiasUseCase = ObterNoticiasUseCase(repositorio)

    val noticias = MutableStateFlow<List<Noticias>>(emptyList())

    fun ProcurarNoticias() {
        viewModelScope.launch {
            try {
                noticias.value = ObterNoticiasUseCase()
            }
            catch (e : Exception){
                noticias.value = emptyList()
            }
        }
    }
}