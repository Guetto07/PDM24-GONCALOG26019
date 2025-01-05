package com.example.carrinhodecompras.domain.use_case

import com.example.carrinhodecompras.domain.model.User
import com.example.carrinhodecompras.domain.repository.RepositorioUser

class LoginUseCase(private val repositorio: RepositorioUser) {
    suspend operator fun invoke(email: String, senha: String): User? {
        return repositorio.Login(email, senha)
    }
}
