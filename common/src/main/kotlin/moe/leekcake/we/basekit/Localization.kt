package moe.leekcake.we.basekit

class Localization(val name: String) {
    fun put(lang: String, text: String): Localization {
        datas.add( LocalizationData(lang, text) )
        return this
    }

    val datas = ArrayList<LocalizationData>()

    data class LocalizationData(val lang: String, val text: String)
}