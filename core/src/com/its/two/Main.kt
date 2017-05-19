package com.its.two

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.physics.box2d.*
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Container
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.ExtendViewport
import java.util.logging.FileHandler

/**
 * Created by Abhishek Aryan on 11-06-2016.
 */

class Main : ApplicationAdapter(),InputProcessor {
    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return  false;
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return  false
    }



    override fun keyTyped(character: Char): Boolean {
        return  false
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scrolled(amount: Int): Boolean {
        return false
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        return false
     //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun keyDown(keycode: Int): Boolean {
        return false
      //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {

        vec3.set(screenX.toFloat(),screenY.toFloat(),0F)

        var cor=cam.unproject(vec3)

        var bodydef=BodyDef()
        bodydef.position.set(cor.x,cor.y)
        bodydef.type=BodyDef.BodyType.DynamicBody

        var poly=PolygonShape()
        poly.setAsBox(20F,5F)


        var fixturedef=FixtureDef()
        fixturedef.shape=poly

        var body=world.createBody(bodydef)
        body.createFixture(fixturedef)

        return false;

       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal lateinit  var batch: SpriteBatch
    internal lateinit var img: Texture

    internal lateinit var stage: Stage
    internal lateinit var world: World
    internal lateinit var b2dRenderer:Box2DDebugRenderer
    internal lateinit var cam:OrthographicCamera

    internal lateinit var vec3:Vector3

    internal lateinit var extendViewport:ExtendViewport

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
        var tex = TextureRegionDrawable(TextureRegion(img))



        world= World(Vector2(0F,-9.8F),true)
        world.setContactListener(MyContactListener())
        b2dRenderer= Box2DDebugRenderer();


        cam= OrthographicCamera();
      //  cam.setToOrtho(false,48F,80F)
        extendViewport=ExtendViewport(48f,80f,cam)

        vec3= Vector3()




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


        var bodydef=BodyDef()
        bodydef.position.set(25F,10F)
        bodydef.type=BodyDef.BodyType.StaticBody

        var poly=PolygonShape()
        poly.setAsBox(20F,5F)


        var fixturedef=FixtureDef()
        fixturedef.shape=poly

        var body=world.createBody(bodydef)
        body.createFixture(fixturedef)




       // container.setSize((tex.getRegion().regionWidth()).toFloat(),tex.region.regionHeight())
        stage= Stage()

       // stage.addActor(container)
        stage.setDebugAll(true)

       // var font= BitmapFont(Gdx.files.internal("dsd"));
        Gdx.input.setInputProcessor(this)

    }

    override fun render() {

        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)



        batch.setProjectionMatrix(cam.combined)
        batch.begin()
        batch.draw(img, 0f, 0f,5f,5f)
        batch.end()

        stage.draw()
        stage.act()

        b2dRenderer.render(world,cam.combined)

        world.step(1/60F,6,2)

    }

    override fun resize(width:Int,height:Int){
        extendViewport.update(width,height)
        extendViewport.camera.position.set(24f,40f,0f)
        extendViewport.camera.update()

    }
}




class MyContactListener:ContactListener{
    override fun postSolve(contact: Contact?, impulse: ContactImpulse?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun preSolve(contact: Contact?, oldManifold: Manifold?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun beginContact(contact: Contact?) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun endContact(contact: Contact?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}