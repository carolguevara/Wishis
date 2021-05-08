package com.example.wishis.intent

sealed class Intent {
    object GetCatEvent: Intent()
    object None: Intent()
}