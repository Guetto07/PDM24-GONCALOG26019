package com.example.appnoticias.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnoticias.data.remote.api.RetrofitInstance
import com.example.appnoticias.data.repository.RepositorioNoticiasIMPL
import com.example.appnoticias.domain.model.Noticias
import com.example.appnoticias.domain.model.NoticiasInfo
import com.example.appnoticias.domain.use_case.ObterNoticiasUseCase
import com.example.appnoticias.domain.use_case.ObterNoticiasInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ObterNoticiasViewModel : ViewModel() {

    private val api = RetrofitInstance.api
    private val repository = RepositorioNoticiasIMPL(api)
    private val getNoticiasUseCase = ObterNoticiasUseCase(repository)
    private val obterNoticiasInfoUseCase = ObterNoticiasInfoUseCase(repository)

    val news = MutableStateFlow<List<Noticias>>(emptyList())

    private val _noticiaInfo = MutableStateFlow<NoticiasInfo?>(null)
    val noticiaInfo: StateFlow<NoticiasInfo?> get() = _noticiaInfo

    fun ProcurarNoticias() {
        viewModelScope.launch {
            news.value = getNoticiasUseCase()
        }
    }

    fun ObterNoticiasInfo(uuid: String) {
        viewModelScope.launch {
            _noticiaInfo.value = obterNoticiasInfoUseCase(uuid)
        }
    }
}
