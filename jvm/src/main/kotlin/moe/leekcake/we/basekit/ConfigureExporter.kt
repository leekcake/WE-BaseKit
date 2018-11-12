package moe.leekcake.we.basekit

import org.json.JSONArray
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
        this is FileConfigure -> this.save()
        this is IntComboBoxConfigure -> this.save()
        this is StringComboBoxConfigure -> this.save()
        else -> baseSave(this)
    }
}

fun ColorConfigure.save(): JSONObject {
    return baseSave(this).put("value", "${colorIntToDouble(r)} ${colorIntToDouble(g)} ${colorIntToDouble(b)}")
        .put("type", "color")
}

fun BoolConfigure.save(): JSONObject {
    return baseSave(this).put("value", bool)
        .put("type", "bool")
}

fun SliderConfigure.save(): JSONObject {
    return baseSave(this).put("value", value)
        .put("min", min)
        .put("max", max)
        .put("editable", editable)
        .put("type", "slider")
}

fun FileConfigure.save(): JSONObject {
    return baseSave(this).put("type", "file")
}

fun<T> comboBaseSave(jsonObject: JSONObject, comboBoxItems: Array<ComboBoxItem<T>>): JSONObject {
    jsonObject.put("type", "combo")
    val options = JSONArray()
    for(item in comboBoxItems) {
        options.put( JSONObject().put("value", item.value).put("label", item.label) )
    }
    return jsonObject
}

fun IntComboBoxConfigure.save(): JSONObject {
    return comboBaseSave(baseSave(this), options)
}

fun StringComboBoxConfigure.save(): JSONObject {
    return comboBaseSave(baseSave(this), options)
}