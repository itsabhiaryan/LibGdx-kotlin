package com.its.two

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Container
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import java.util.logging.FileHandler

/**
 * Created by Abhishek Aryan on 11-06-2016.
 */

class Main : ApplicationAdapter() {

    internal lateinit  var batch: SpriteBatch
    internal lateinit var img: Texture

    internal lateinit var stage: Stage



    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
        var tex = TextureRegionDrawable(TextureRegion(img))


//        if(Gdx.app.type==Application.ApplicationType.Android) {
//
//            var assetManager = AssetManager(ExternalFileHandleResolver())
//
//            var fileHandle = Gdx.files.external("/Download/WorldmapTheme.mp3")
//
//            if (fileHandle.exists()) {
//
//                assetManager.load(fileHandle.path(), Music::class.java)
//                assetManager.finishLoading();
//
//                var music = assetManager.get<Music>(fileHandle.path())
//                music.setLooping(true)
//                music.play()
//            }
//        }



        var buttonstyle=Button.ButtonStyle(tex,tex,tex)
        var but= Button(buttonstyle)
        var container= Container(but)

        but.setSize(200F,200F)

        but.setFillParent(true)
        container.setPosition(200F,200F);

        container.fill()

       // container.setSize((tex.getRegion().regionWidth()).toFloat(),tex.region.regionHeight())
        stage= Stage()

        stage.addActor(container)
        stage.setDebugAll(true)

       // var font= BitmapFont(Gdx.files.internal("dsd"));

    }

    override fun render() {

        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()

        stage.draw()
        stage.act()
    }

}
