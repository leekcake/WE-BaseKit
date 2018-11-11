package moe.leekcake.we.sample.manager

import moe.leekcake.we.basekit.Leader
import moe.leekcake.we.basekit.manager.CanvasManager
import moe.leekcake.we.sample.ConfigureStore
import moe.leekcake.we.sample.SampleLeader
import kotlin.math.PI

class MainCanvasManager(leader: SampleLeader) : CanvasManager<SampleLeader>(leader) {
    override val canvasName: String
        get() = "mainCanvas"

    fun drawCenterCircle() {
        console.info("drawCenterCircle!")
        val halfWidth = canvas.width / 2.0
        val halfHeight = canvas.height / 2.0
        val circleRadius = halfHeight * 0.6

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
        drawCenterCircle()
    }
}