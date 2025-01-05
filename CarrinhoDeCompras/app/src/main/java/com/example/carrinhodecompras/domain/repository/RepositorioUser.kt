package com.example.carrinhodecompras.domain.repository

import com.example.carrinhodecompras.domain.model.User

interface RepositorioUser{
    suspend fun Login(email: String, senha: String): User?
}
