package com.example.playground.content.sso

import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class SsoViewModel: ViewModel() {

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("1")
        .requestEmail()
        .build()

}