package com.erzhan.bishkek.data

class Place constructor(name: String, location: String) {

    var name: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var location: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    private val imageProvide = -1
    var imageResourceId: Int = -1
        get() {
            return field
        }

    init {
        this.name = name
        this.location = location
    }

    constructor(name: String, location: String, imageResourceId: Int) : this(name, location) {
        this.imageResourceId = imageResourceId
    }


    fun hasImage(): Boolean {
        return imageResourceId != imageProvide
    }
}