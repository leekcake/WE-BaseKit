package moe.leekcake.we.basekit.manager

import moe.leekcake.we.basekit.Leader
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document

abstract class CanvasManager(leader: Leader) : BaseManager<Leader>(leader) {
    abstract val canvasName: String

    lateinit var canvas: HTMLCanvasElement
    lateinit var canvasCtx: CanvasRenderingContext2D

    override fun init() {
        canvas = document.getElementById(canvasName) as HTMLCanvasElement
        canvasCtx = canvas.getContext("2d") as CanvasRenderingContext2D
    }

    override fun destroy() {

    }
}