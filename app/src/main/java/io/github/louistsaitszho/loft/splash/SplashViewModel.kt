package io.github.louistsaitszho.loft.splash

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.ScopedViewModel
import kotlinx.coroutines.experimental.launch

class SplashViewModel(private val repository: SplashRepository) : ScopedViewModel() {
    private val _sceneAfterSplash = MutableLiveData<SceneAfterSplash>()
    val sceneAfterSplash: LiveData<SceneAfterSplash>
        get() = _sceneAfterSplash

    fun findNextScene() {
        launch {
            if (repository.isSignedIn()) {
                _sceneAfterSplash.postValue(SceneAfterSplash.MAIN)
            } else {
                _sceneAfterSplash.postValue(SceneAfterSplash.ONBOARDING)
            }
        }
    }

    enum class SceneAfterSplash {
        ONBOARDING,
        MAIN
    }
}