package moe.leekcake.we.sample

import moe.leekcake.we.basekit.*

class SampleProject : Project {
    override val configures: Array<Configure>
        get() = arrayOf(
            ConfigureStore.circle,
            ConfigureStore.circleLineColor,
            ConfigureStore.fillCircle,
            ConfigureStore.circleFillColor,
            ConfigureStore.spectrum,
            ConfigureStore.spectrumColor,
            ConfigureStore.useLerp,
            ConfigureStore.lerpPower
        )
    override val localizations: Array<Localization>
        get() = arrayOf(
            Localization("ui_circle")
                .put("en-US", "Circle")
                .put("ko-KR", "원"),
            Localization("ui_circleLineColor")
                .put("en-US", "Circle Line Color")
                .put("ko-KR", "원 선색"),
            Localization("ui_fillCircle")
                .put("en-US", "Fill Circle")
                .put("ko-KR", "원 채우기"),
            Localization("ui_circleFillColor")
                .put("en-US", "Circle Fill Color")
                .put("ko-KR", "원을 채울 색"),
            Localization("ui_spectrum")
                .put("en-US", "Spectrum")
                .put("ko-KR", "스펙트럼"),
            Localization("ui_spectrumColor")
                .put("en-US", "Spectrum Color")
                .put("ko-KR", "스펙트럼 색"),
            Localization("ui_useLerp")
                .put("en-US", "Use lerp")
                .put("ko-KR", "부드럽게 하기"),
            Localization("ui_lerpPower")
                .put("en-US", "Lerp power")
                .put("ko-KR", "부드럽지 않은 정도")
        )
    override val supportAudioProcessing: Boolean
        get() = true
    override val title: String
        get() = "샘플"

}