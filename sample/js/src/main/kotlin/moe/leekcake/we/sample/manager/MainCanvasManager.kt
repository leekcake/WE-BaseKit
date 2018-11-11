package moe.leekcake.we.sample.manager

import moe.leekcake.we.basekit.Leader
import moe.leekcake.we.basekit.Utils.halfPI
import moe.leekcake.we.basekit.get
import moe.leekcake.we.basekit.manager.CanvasManager
import moe.leekcake.we.sample.ConfigureStore
import moe.leekcake.we.sample.SampleLeader
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MainCanvasManager(leader: SampleLeader) : CanvasManager<SampleLeader>(leader) {
    override val canvasName: String
        get() = "mainCanvas"

    var halfWidth = 0.0
    var halfHeight = 0.0

    var circleRadius = 0.0
    var spectrumRadius = 0.0

    fun drawAudioSpectrumSingle(index: Int, halfCount: Double) {
        val value = leader.audioManager.audioArray[index]

        val power = spectrumRadius * value
        val radian = halfPI + ((index.toDouble() / halfCount) * PI)

        val cx = halfWidth + (circleRadius * cos(radian))
        val cy = halfHeight + (circleRadius * sin(radian))

        canvasCtx.moveTo(cx, cy)
        canvasCtx.lineTo(cx + (power * cos(radian)),
            cy + (power * sin(radian)))
    }

    fun drawAudioSpectrum() {
        if(!leader.audioManager.audioArrayInited) {
            return
        }
        val halfCount = leader.audioManager.audioArray.size / 2.0

        canvasCtx.strokeStyle = ConfigureStore.spectrumColor.get(leader)
        canvasCtx.lineWidth = 12.0

        canvasCtx.beginPath()
        for (i in 0 until leader.audioManager.audioArray.size) {
            drawAudioSpectrumSingle(i, halfCount)
        }
        canvasCtx.stroke()
    }

    fun drawCenterCircle() {
        halfWidth = canvas.width / 2.0
        halfHeight = canvas.height / 2.0

        circleRadius = halfHeight * 0.6
        spectrumRadius = halfHeight * 0.3

        canvasCtx.beginPath()
        canvasCtx.arc(halfWidth, halfHeight, circleRadius, 0.0, 2 * PI, false)

        if( leader.configureManager.getBoolConfigure( ConfigureStore.fillCircle ) ) {
            canvasCtx.fillStyle = leader.configureManager.getColorConfigure( ConfigureStore.circleFillColor )
            canvasCtx.fill()
        }

        canvasCtx.lineWidth = 7.5
        canvasCtx.strokeStyle = leader.configureManager.getColorConfigure( ConfigureStore.circleLineColor )
        canvasCtx.stroke()
    }

    override fun update() {
        canvasCtx.clearRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
        drawAudioSpectrum()
        drawCenterCircle()
    }
}