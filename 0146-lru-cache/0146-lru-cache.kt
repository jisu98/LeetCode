class LRUCache(val capacity: Int) {
    val map = linkedMapOf<Int, Int>()

    fun get(key: Int): Int {
        if (!map.containsKey(key)) return -1

        map[key] = map.remove(key)!!
        return map[key]!!
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map.remove(key)
            map[key] = value
        } else if (map.size < capacity) {
            map[key] = value
        } else {
            map.remove(map.keys.first())
            map[key] = value
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */