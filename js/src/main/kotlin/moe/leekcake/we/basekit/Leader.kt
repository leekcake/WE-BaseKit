package moe.leekcake.we.basekit

import moe.leekcake.we.basekit.manager.AudioManager
import moe.leekcake.we.basekit.manager.BaseManager
import moe.leekcake.we.basekit.manager.ConfigureManager
import kotlin.browser.window

open class Leader(val project: Project) {
    val managers = ArrayList<BaseManager<*>>()

    val configureManager = addManager(ConfigureManager(this))

    fun<T2 : Leader, T : BaseManager<T2>> addManager(manager: T): T {
        managers.add(manager)
        return manager
    }

    inline fun<reified T: BaseManager<*>> getManager(): T? {
        for(manager in managers) {
            if(manager is T) {
                return manager
            }
        }
        return null
    }

    fun init() {
        for(manager in managers) {
            manager.init()
        }
        requestUpdate()
    }

    fun updateCallback(timestrap: Double) {
        for(manager in managers) {
            manager.update()
        }
        requestUpdate()
    }

    fun requestUpdate() {
        window.requestAnimationFrame {
            updateCallback(it)
        }
    }

    fun destroy() {
        for(manager in managers) {
            manager.destroy()
        }
    }
}