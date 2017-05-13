package com.its.two.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.its.two.Main

object DesktopLauncher1 {

    @JvmStatic fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = 400
        config.height = 640

        LwjglApplication(Main(), config)
    }
}

