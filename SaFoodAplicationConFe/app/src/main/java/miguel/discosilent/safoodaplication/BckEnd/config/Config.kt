package miguel.discosilent.safoodaplication.BckEnd.config

import android.content.Context

object Config {
    var apiKey: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlhdXhsd2xpZWxkb3Noa3lqeGV0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzY0NjA5NjcsImV4cCI6MjA1MjAzNjk2N30.rx_bIFw7ZoOEfr2y2NhtTs1Gw_ZoWYI7KlLsxpJgs90"
    var authToken: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlhdXhsd2xpZWxkb3Noa3lqeGV0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzY0NjA5NjcsImV4cCI6MjA1MjAzNjk2N30.rx_bIFw7ZoOEfr2y2NhtTs1Gw_ZoWYI7KlLsxpJgs90"
    var authTokenAux: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlhdXhsd2xpZWxkb3Noa3lqeGV0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzY0NjA5NjcsImV4cCI6MjA1MjAzNjk2N30.rx_bIFw7ZoOEfr2y2NhtTs1Gw_ZoWYI7KlLsxpJgs90"

    fun updateAuthToken(context: Context, newAuthToken: String) {
        authToken = "Bearer $newAuthToken"
        val sharedPreferences = context.getSharedPreferences("Config", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("authToken", authToken)
            apply()
        }
    }

    fun restoreAuthToken(context: Context) {
        if (authTokenAux.isNotEmpty()) {
            authToken = authTokenAux
            val sharedPreferences = context.getSharedPreferences("Config", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("authToken", authToken)
                apply()
            }
        }
    }


    fun loadAuthToken(context: Context) {
        val sharedPreferences = context.getSharedPreferences("Config", Context.MODE_PRIVATE)
        authToken = sharedPreferences.getString("authToken", authToken) ?: authToken
    }
}
