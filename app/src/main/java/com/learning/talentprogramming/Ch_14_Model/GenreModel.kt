package com.learning.talentprogramming.Ch_14_Model

class GenreModel(private var id : Int, private var name : String){
    //Setters
    fun setId( id : Int){
        this.id = id
    }
    fun setName ( name : String){
        this.name = name
    }
    //Getters
    fun getId() : Int = id
    fun getName() : String = name

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GenreModel

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }

}
