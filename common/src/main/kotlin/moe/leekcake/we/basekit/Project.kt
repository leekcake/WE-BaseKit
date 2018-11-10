package moe.leekcake.we.basekit

interface Project {
    val title: String
    val supportAudioProcessing: Boolean
    val configures: Array<Configure>
    val localizations: Array<Localization>
}