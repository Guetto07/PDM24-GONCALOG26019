package com.example.carrinhodecompras.domain.repository

import com.example.carrinhodecompras.domain.model.User

interface RepositorioUser{
    suspend fun fazerLogin(email: String, senha: String): User?
}
