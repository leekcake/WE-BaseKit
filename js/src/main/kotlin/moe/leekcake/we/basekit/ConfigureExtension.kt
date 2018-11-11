package moe.leekcake.we.basekit

fun ColorConfigure.get(leader: Leader): String {
    return leader.configureManager.getColorConfigure(this)
}

fun BoolConfigure.get(leader: Leader): Boolean {
    return leader.configureManager.getBoolConfigure(this)
}

fun SliderConfigure.get(leader: Leader): Int {
    return leader.configureManager.getSilderConfigure(this)
}