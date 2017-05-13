package com.its.two.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.its.two.*;

public class DesktopLauncher {

    public static void main(String arg[]) {

        LwjglApplicationConfiguration config=new LwjglApplicationConfiguration();
        config.width = 400;
        config.height = 640;
        config.title = "Kotlin";

        new LwjglApplication(new Main(),config);

    }
}