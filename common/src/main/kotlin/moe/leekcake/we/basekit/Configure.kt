package moe.leekcake.we.basekit

abstract class Configure(val name: String, val text: String)

class EmptyConfigure(name: String, text: String) : Configure(name, text)

class ColorConfigure(name: String, text: String, val r: Int, val g: Int, val b: Int) : Configure(name, text)

class BoolConfigure(name: String, text: String, val bool: Boolean) : Configure(name, text)

class SliderConfigure(name: String, text: String, val value: Int, val min: Int, val max: Int, val editable: Boolean) : Configure(name, text)

class FileConfigure(name: String, text: String) : Configure(name, text)

class ComboBoxItem<T>(val label: String, val value: T)

class IntComboBoxConfigure(name: String, text: String, val options: Array<ComboBoxItem<Int>>, val value: Int) : Configure(name, text)

class StringComboBoxConfigure(name: String, text: String, val options: Array<ComboBoxItem<String>>, val value: String) : Configure(name, text)

class TextInputConfigure(name: String, text: String, val value: String) : Configure(name, text)

