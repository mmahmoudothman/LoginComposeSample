package com.ozman.test.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozman.test.domain.model.Post
import com.ozman.test.domain.reposint.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            repository.getPost()
                .catch { e ->
                    // Handle error
                }
                .collect { postList ->
                    _posts.value = postList
                }
        }
    }
}
