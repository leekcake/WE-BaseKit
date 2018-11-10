package moe.leekcake.we.sample

import moe.leekcake.we.basekit.BoolConfigure
import moe.leekcake.we.basekit.ColorConfigure
import moe.leekcake.we.basekit.EmptyConfigure
import moe.leekcake.we.basekit.SliderConfigure

object ConfigureStore {
    val circle = EmptyConfigure("circle", "ui_circle")
    val circleLineColor = ColorConfigure("circleLineColor", "ui_circleLineColor", 255, 255, 140)
    val fillCircle = BoolConfigure("fillCircle", "ui_fillCircle", false)
    val circleFillColor = ColorConfigure("circleFillColor", "ui_circleFillColor", 255, 255, 140)

    val spectrum = EmptyConfigure("spectrum", "ui_spectrum")
    val spectrumColor = ColorConfigure("spectrumColor", "ui_spectrumColor", 255, 184, 196)
    val useLerp = BoolConfigure("useLerp", "ui_useLerp", true)
    val lerpPower = SliderConfigure("lerpPower", "ui_lerpPower", 39, 10, 100, true)

}