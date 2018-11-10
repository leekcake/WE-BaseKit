package moe.leekcake.we.basekit

import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLImageElement
import kotlin.math.PI
import kotlin.math.min
import kotlin.math.abs
import kotlin.math.round

fun Number.toFixed(digits: Int): Number {
    return this.asDynamic().toFixed(digits) as Number
}

object Utils {
    val halfPI = PI * 0.5f
    val radian145 = (PI * 5) / 4

    fun blendArray(array: Array<Double>, start: Int, end: Int, useClamp: Boolean = true): Double {
        var result = 0.0
        for(value in array) {
            result += if(useClamp) min(1.0, value) else value
        }
        return result
    }

    fun normalize(value: Double, min: Double, max: Double): Double {
        return abs( (value - min).toFixed(1).toDouble() / (max - min).toFixed(1).toDouble() )
    }

    fun lerp(a: Double, b: Double, n: Double): Double {
        return (1-n)*a + n*b
    }

    fun lerpColor(src: String, dest: String, progress: Double): String {
        fun lerpColorInner(a: String, b: String, n: Double): Int {
            return round(a.toInt() + (b.toInt() - a.toInt()) * n).toInt()
        }

        val trimSrc = src.replace(" " , "");
        val trimDest = dest.replace(" " , "");
        if(trimSrc.startsWith("rgb(") && trimDest.startsWith("rgb(")) {
            val srcData = trimSrc.split(",")
            val destData = trimDest.split(",")

            val result = StringBuilder()
            for(i in 0..srcData.size) {
                result.append( lerpColorInner(srcData[i], destData[i], progress) )
                result.append(",")
            }
            result.removeRange(result.length - 1, result.length - 1)
            result.append(")")

            return result.toString()
        }
        else
        {
            console.error("src($trimSrc) or dest($trimDest) is not color?")
            return ""
        }
    }

    fun drawInCenter(canvas: HTMLCanvasElement, canvasCtx: CanvasRenderingContext2D, image: HTMLImageElement, scale: Double) {
        val width = image.width * scale
        val height = image.height * scale

        canvasCtx.drawImage(image, canvas.width / 2 - width / 2, canvas.height / 2 - height / 2, width, height)
    }

    fun drawPart(canvasCtx: CanvasRenderingContext2D, partImage: HTMLImageElement, x: Double, y: Double, addX: Double, addY: Double, scale: Double) {
        canvasCtx.drawImage(partImage, x + (addX * scale), y + (addY * scale),
            partImage.width * scale, partImage.height * scale)
    }
}