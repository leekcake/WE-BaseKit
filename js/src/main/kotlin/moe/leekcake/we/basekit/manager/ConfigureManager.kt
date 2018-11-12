package moe.leekcake.we.basekit.manager

import moe.leekcake.we.basekit.*
import org.w3c.dom.events.Event
import kotlin.browser.window
import kotlin.math.round
import kotlin.math.roundToInt

external fun decodeURI(encodedURI: dynamic): dynamic

class ConfigureManager(leader: Leader) : BaseManager<Leader>(leader) {
    private val dataMap = HashMap<String, dynamic>()

    fun getBoolConfigure(boolConfigure: BoolConfigure) : Boolean {
        if(!dataMap.containsKey(boolConfigure.name)) {
            return boolConfigure.bool
        }
        return dataMap[boolConfigure.name]
    }

    fun getSilderConfigure(sliderConfigure: SliderConfigure) : Int {
        if(!dataMap.containsKey(sliderConfigure.name)) {
            return sliderConfigure.value
        }
        return dataMap[sliderConfigure.name]
    }

    fun colorToWeb(r: Int, g: Int, b: Int): String {
        return "rgb($r,$g,$b)"
    }

    fun colorEngineToWeb(data: String): String {
        val web = data.split(" ").map {
            (it.toDouble() * 255).roundToInt()
        }
        return colorToWeb(web[0], web[1], web[2])
    }

    fun getColorConfigure(colorConfigure: ColorConfigure) : String {
        if (!dataMap.containsKey(colorConfigure.name)) {
            return colorToWeb(colorConfigure.r, colorConfigure.g, colorConfigure.b)
        }
        return colorEngineToWeb(dataMap[colorConfigure.name])
    }

    fun getFileConfigure(fileConfigure: FileConfigure) : String {
        if (!dataMap.containsKey(fileConfigure.name)) {
            return ""
        }
        return "file:///${decodeURI(dataMap[fileConfigure.name])}"
    }

    override fun init() {
        val listener = Any().asDynamic()
        listener.manager = this
        listener.applyUserProperties = { prop: dynamic ->
            for(configure in leader.project.configures) {
                dataMap[configure.name] = prop[configure.name].value
            }
        }
        window.asDynamic().wallpaperPropertyListener = listener
    }

    override fun update() {

    }

    override fun destroy() {

    }
}