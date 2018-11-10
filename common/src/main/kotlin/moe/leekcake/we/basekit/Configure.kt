package moe.leekcake.we.basekit

abstract class Configure(val name: String, val text: String)

class EmptyConfigure(name: String, text: String) : Configure(name, text)

class ColorConfigure(name: String, text: String, val r: Int, val g: Int, val b: Int) : Configure(name, text)

class BoolConfigure(name: String, text: String, val bool: Boolean) : Configure(name, text)

class SliderConfigure(name: String, text: String, val value: Int, val min: Int, val max: Int, val editable: Boolean) : Configure(name, text)
