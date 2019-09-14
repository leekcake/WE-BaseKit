package moe.leekcake.we.basekit.manager

import moe.leekcake.we.basekit.BoolConfigure
import moe.leekcake.we.basekit.Leader
import moe.leekcake.we.basekit.SliderConfigure
import moe.leekcake.we.basekit.Utils
import kotlin.browser.window

class AudioManager(leader: Leader) : BaseManager<Leader>(leader) {
    //Current audio data
    lateinit var audioArray: Array<Double>

    //Latest audio data
    lateinit private var latestAudioArray: Array<Double>

    val audioArrayInited
        get() = ::latestAudioArray.isInitialized && ::audioArray.isInitialized

    override fun init() {
        try {
            window.asDynamic().wallpaperRegisterAudioListener { audio: dynamic ->

                latestAudioArray = audio as Array<Double>
                if (!audioArrayInited) {
                    audioArray = latestAudioArray
                }

                Unit
            }
        } catch (e : dynamic) {
            println("Failed to init AudioManager, may be not using wallpaper engine?")
        }
    }

    var useLerpProperty : BoolConfigure? = null
    var lerpPowerProperty : SliderConfigure? = null

    override fun update() {
        if(!audioArrayInited) {
            return
        }

        if(useLerpProperty != null && leader.configureManager.getBoolConfigure(useLerpProperty!!)) {
            val lerpPower = if(lerpPowerProperty != null) leader.configureManager.getSilderConfigure(lerpPowerProperty!!) / 100.0
            else 0.39

            for(i in 0..latestAudioArray.size) {
                audioArray[i] = Utils.lerp(audioArray[i], latestAudioArray[i], lerpPower)
            }
        }
        else
        {
            audioArray = latestAudioArray
        }
    }

    override fun destroy() {

    }
}