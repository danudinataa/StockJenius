package com.ramaa.pmobile_uas.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ramaa.pmobile_uas.domain.usecases.stocks.GetListNews
import com.ramaa.pmobile_uas.presentation.news.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    listNewsUseCases: GetListNews
): ViewModel() {

    var state = mutableStateOf(NewsState())
        private set

    val characters = listNewsUseCases().cachedIn(viewModelScope)

}