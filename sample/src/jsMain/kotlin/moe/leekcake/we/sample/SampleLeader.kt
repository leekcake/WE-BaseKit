package moe.leekcake.we.sample

import moe.leekcake.we.basekit.Leader
import moe.leekcake.we.basekit.Project
import moe.leekcake.we.basekit.manager.AudioManager

class SampleLeader(project: Project) : Leader(project) {
    val audioManager = addManager(AudioManager(this))

    init {
        audioManager.useLerpProperty = ConfigureStore.useLerp
        audioManager.lerpPowerProperty = ConfigureStore.lerpPower
    }
}