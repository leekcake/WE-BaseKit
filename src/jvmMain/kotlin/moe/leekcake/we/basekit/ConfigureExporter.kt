package moe.leekcake.we.basekit

import org.json.JSONObject

fun colorIntToDouble(value: Int): Double {
    return value / 255.0
}

fun baseSave(configure: Configure): JSONObject {
    return JSONObject().put("text", configure.text)
}

fun Configure.save(): JSONObject {
    return when {
        this is ColorConfigure -> this.save()
        this is BoolConfigure -> this.save()
        this is SliderConfigure -> this.save()
        else -> baseSave(this)
    }
}

fun ColorConfigure.save(): JSONObject {
    return baseSave(this).put("value", "${colorIntToDouble(r)} ${colorIntToDouble(g)} ${colorIntToDouble(b)}")
}

fun BoolConfigure.save(): JSONObject {
    return baseSave(this).put("value", bool)
}

fun SliderConfigure.save(): JSONObject {
    return baseSave(this).put("value", value)
        .put("min", min)
        .put("max", max)
        .put("editable", editable)
}