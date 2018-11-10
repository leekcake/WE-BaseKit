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

    override fun init() {
        window.asDynamic().wallpaperRegisterAudioListener {
                audio: dynamic ->

            latestAudioArray = audio as Array<Double>
            if(!::audioArray.isInitialized) {
                audioArray = latestAudioArray
            }

            Unit
        }
    }

    var useLerpProperty : BoolConfigure? = null
    var lerpPowerProperty : SliderConfigure? = null

    override fun update() {
        if(useLerpProperty != null && leader.getManager<ConfigureManager>()!!.getBoolConfigure(useLerpProperty!!)) {
            val lerpPower = if(lerpPowerProperty != null) leader.getManager<ConfigureManager>()!!.getSilderConfigure(lerpPowerProperty!!) / 100.0
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