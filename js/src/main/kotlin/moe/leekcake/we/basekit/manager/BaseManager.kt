package moe.leekcake.we.basekit.manager

import moe.leekcake.we.basekit.Leader

abstract class BaseManager<T : Leader>(val leader: T) {
    abstract fun init()
    abstract fun update()
    abstract fun destroy()
}