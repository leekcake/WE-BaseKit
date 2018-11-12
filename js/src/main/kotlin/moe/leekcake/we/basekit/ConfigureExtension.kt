package moe.leekcake.we.basekit

fun ColorConfigure.listen(leader: Leader, listener: (String) -> Unit) {
    leader.configureManager.registerChangeListener(this) {
        listener.invoke( get(leader) )
    }
}

fun ColorConfigure.get(leader: Leader): String {
    return leader.configureManager.getColorConfigure(this)
}

fun BoolConfigure.listen(leader: Leader, listener: (Boolean) -> Unit) {
    return leader.configureManager.registerChangeListener(this) {
        listener.invoke(get(leader))
    }
}

fun BoolConfigure.get(leader: Leader): Boolean {
    return leader.configureManager.getBoolConfigure(this)
}

fun SliderConfigure.listen(leader: Leader, listener: (Int) -> Unit) {
    return leader.configureManager.registerChangeListener(this) {
        listener.invoke(get(leader))
    }
}

fun SliderConfigure.get(leader: Leader): Int {
    return leader.configureManager.getSilderConfigure(this)
}

fun FileConfigure.listen(leader: Leader, listener: (String) -> Unit) {
    return leader.configureManager.registerChangeListener(this) {
        listener.invoke(get(leader))
    }
}

fun FileConfigure.get(leader: Leader): String {
    return leader.configureManager.getFileConfigure(this)
}

fun IntComboBoxConfigure.listen(leader: Leader, listener: (Int) -> Unit) {
    return leader.configureManager.registerChangeListener(this) {
        listener.invoke(get(leader))
    }
}

fun IntComboBoxConfigure.get(leader: Leader): Int {
    return leader.configureManager.getIntComboBoxConfigure(this)
}

fun StringComboBoxConfigure.listen(leader: Leader, listener: (String) -> Unit) {
    return leader.configureManager.registerChangeListener(this) {
        listener.invoke(get(leader))
    }
}

fun StringComboBoxConfigure.get(leader: Leader): String {
    return leader.configureManager.getStringComboBoxConfigure(this)
}

fun TextInputConfigure.listen(leader: Leader, listener: (String) -> Unit) {
    return leader.configureManager.registerChangeListener(this) {
        listener.invoke(get(leader))
    }
}

fun TextInputConfigure.get(leader: Leader): String {
    return leader.configureManager.getTextInputConfigure(this)
}

