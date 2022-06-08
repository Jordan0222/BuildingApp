package com.jordan.buildingapp.data.paging

interface Paginator<Key, Item> {
    suspend fun loadNextItem()
    fun reset()
}