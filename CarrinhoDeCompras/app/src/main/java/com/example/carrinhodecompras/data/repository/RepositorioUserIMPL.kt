package com.example.carrinhodecompras.data.repository

import com.example.carrinhodecompras.domain.model.User
import com.example.carrinhodecompras.domain.repository.RepositorioUser

class RepositorioUserIMPL : RepositorioUser {
    override suspend fun Login(email: String, senha: String): User? {

        return if (email == "usuario@example.com" && senha == "senha123") {
            User(id = "1", email = email, senha = senha)
        } else {
            null
        }
    }
}
