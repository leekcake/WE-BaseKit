package moe.leekcake.we.sample

import moe.leekcake.we.basekit.*

class SampleProject : Project {
    override val configures: Array<Configure>
        get() = arrayOf(
            EmptyConfigure("base", "베이스"),
            ColorConfigure("color", "컬러", 255, 255, 255),
            BoolConfigure("bool", "체크", false),
            SliderConfigure("slider", "슬라이더", 50, 0, 100, true)
        )
    override val localizations: Array<Localization>
        get() = arrayOf(
            Localization("test", "en-US", "Test"),
            Localization("test", "ko-KR", "테스트")
        )
    override val supportAudioProcessing: Boolean
        get() = true
    override val title: String
        get() = "샘플"

}