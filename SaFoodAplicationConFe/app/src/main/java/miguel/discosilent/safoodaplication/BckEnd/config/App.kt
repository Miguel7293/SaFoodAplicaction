package miguel.discosilent.safoodaplication.BckEnd.config

import android.app.Application
import miguel.discosilent.safoodaplication.BckEnd.config.Config

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Config.loadAuthToken(this)
    }
}