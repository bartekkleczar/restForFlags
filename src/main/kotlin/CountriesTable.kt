package org.example

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object CountriesTable : IdTable<String>("countriestable") {
    override val id: Column<EntityID<String>> = varchar("code", 3).entityId()
    val flagPath = text("flag_path")
    val name = text("name")
    val red = integer("red")
    val green = integer("green")
    val blue = integer("blue")
    val yellow = integer("yellow")
    val orange = integer("orange")
    val white = integer("white")
    val black = integer("black")
    val horizontal = integer("horizontal")
    val vertical = integer("vertical")
    val diagonal = integer("diagonal")
    val centered = integer("centered")
    val triangleHorizontal = integer("trianglehorizontal")
    val other = integer("other")
    val circleSign = integer("circle_sign")
    val crescentSign = integer("crescent_sign")
    val crossSign = integer("cross_sign")
    val starSign = integer("star_sign")
    val sunSign = integer("sun_sign")
    val otherSign = integer("other_sign")
    val noSigns = integer("nosigns")
}