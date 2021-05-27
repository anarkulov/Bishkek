package com.erzhan.bishkek.data

class Place constructor(name: String, district: String, imageResourceId: Int, description: String, location: String, mapLocation: String) {

    var name: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }
    var district: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var description: String = ""
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

    var mapLocation: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var imageResourceId: Int
        get() {
            return field
        }

    private val phoneProvided = ""
    var phoneNumber: String = ""
        get() {
            return field
        }

    constructor(name: String, district: String, imageResourceId: Int, description: String, location: String, mapLocation: String, phoneNumber: String) : this(name, district, imageResourceId, description, location, mapLocation) {
        this.phoneNumber = phoneNumber
    }

    init {
        this.name = name
        this.district = district
        this.description = description
        this.location = location
        this.mapLocation = mapLocation
        this.imageResourceId = imageResourceId
    }

    fun hasPhone(): Boolean {
        return phoneNumber != phoneProvided
    }

}