package com.firebasemultiplelogins.utils

sealed class ServerResponse {
    class Success(val data: Any) : ServerResponse()
    class Failed(val errorMsg: String) : ServerResponse()
}