package com.example.tarokapp

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String)

interface ApiService {
    @POST("/api/users/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("/api/profiles/{profileId}/games")
    suspend fun getGamesForProfile(@Path("profileId") profileId: String): List<Game>
}
