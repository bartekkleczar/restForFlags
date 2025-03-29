package org.example

import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class CountriesRepository {

    fun findCountriesByFilters(
        red: Int = 0,
        green: Int = 0,
        blue: Int = 0,
        yellow: Int = 0,
        orange: Int = 0,
        white: Int = 0,
        black: Int = 0,
        horizontal: Int = 0,
        vertical: Int = 0,
        diagonal: Int = 0,
        centered: Int = 0,
        triangleHorizontal: Int = 0,
        other: Int = 0,
        circleSign: Int = 0,
        crescentSign: Int = 0,
        crossSign: Int = 0,
        starSign: Int = 0,
        sunSign: Int = 0,
        otherSign: Int = 0,
        noSigns: Int = 0,

        ): List<CountryDTO> {
        return transaction {
            CountriesTable.selectAll().apply {
                if (red != 0) andWhere { CountriesTable.red eq red }
                if (green != 0) andWhere { CountriesTable.green eq green }
                if (blue != 0) andWhere { CountriesTable.blue eq blue }
                if (yellow != 0) andWhere { CountriesTable.yellow eq yellow }
                if (orange != 0) andWhere { CountriesTable.orange eq orange }
                if (white != 0) andWhere { CountriesTable.white eq white }
                if (black != 0) andWhere { CountriesTable.black eq black }
                if (horizontal != 0) andWhere { CountriesTable.horizontal eq horizontal }
                if (vertical != 0) andWhere { CountriesTable.vertical eq vertical }
                if (diagonal != 0) andWhere { CountriesTable.diagonal eq diagonal }
                if (centered != 0) andWhere { CountriesTable.centered eq centered }
                if (triangleHorizontal != 0) andWhere { CountriesTable.triangleHorizontal eq triangleHorizontal }
                if (other != 0) andWhere { CountriesTable.other eq other }
                if (circleSign != 0) andWhere { CountriesTable.circleSign eq circleSign }
                if (crescentSign != 0) andWhere { CountriesTable.crescentSign eq crescentSign }
                if (crossSign != 0) andWhere { CountriesTable.crossSign eq crossSign }
                if (starSign != 0) andWhere { CountriesTable.starSign eq starSign }
                if (sunSign != 0) andWhere { CountriesTable.sunSign eq sunSign }
                if (otherSign != 0) andWhere { CountriesTable.otherSign eq otherSign }
                if (noSigns != 0) andWhere { CountriesTable.noSigns eq noSigns }
            }.map{ row ->
                val code = row[CountriesTable.id].value
                val flagUrl = "http://localhost:8080/flags/$code"
                CountryDTO(
                    code = code,
                    name = row[CountriesTable.name],
                    flagUrl = flagUrl
                )
            }
        }
    }
    /*
    fun findCountriesByFlagColors(
        red: Int = 0,
        green: Int = 0,
        blue: Int = 0,
        yellow: Int = 0,
        orange: Int = 0,
        white: Int = 0,
        black: Int = 0
    ): List<CountryDTO> {
        return transaction {
            CountriesTable.selectAll().apply {
                if (red != 0) andWhere { CountriesTable.red eq red }
                if (green != 0) andWhere { CountriesTable.green eq green }
                if (blue != 0) andWhere { CountriesTable.blue eq blue }
                if (yellow != 0) andWhere { CountriesTable.yellow eq yellow }
                if (orange != 0) andWhere { CountriesTable.orange eq orange }
                if (white != 0) andWhere { CountriesTable.white eq white }
                if (black != 0) andWhere { CountriesTable.black eq black }
            }.map{ row ->
                CountryDTO(
                    code = row[CountriesTable.id].value,
                    name = row[CountriesTable.name],
                    flagPath = row[CountriesTable.flagPath]
                )
            }
        }
    }

    fun findCountriesByFlagLayout(
        horizontal: Int = 0,
        vertical: Int = 0,
        diagonal: Int = 0,
        centered: Int = 0,
        triangleHorizontal: Int = 0,
        other: Int = 0
    ): List<CountryDTO> {
        return transaction {
            CountriesTable.selectAll().apply {
                if (horizontal != 0) andWhere { CountriesTable.horizontal eq horizontal }
                if (vertical != 0) andWhere { CountriesTable.vertical eq vertical }
                if (diagonal != 0) andWhere { CountriesTable.diagonal eq diagonal }
                if (centered != 0) andWhere { CountriesTable.centered eq centered }
                if (triangleHorizontal != 0) andWhere { CountriesTable.triangleHorizontal eq triangleHorizontal }
                if (other != 0) andWhere { CountriesTable.other eq other }
            }.map{ row ->
                CountryDTO(
                    code = row[CountriesTable.id].value,
                    name = row[CountriesTable.name],
                    flagPath = row[CountriesTable.flagPath]
                )
            }
        }
    }


    fun findCountriesByFlagSymbols(
        circleSign: Int = 0,
        crescentSign: Int = 0,
        crossSign: Int = 0,
        starSign: Int = 0,
        sunSign: Int = 0,
        otherSign: Int = 0,
        noSigns: Int = 0
    ): List<CountryDTO> {
        return transaction {
            CountriesTable.selectAll().apply {
                if (circleSign != 0) andWhere { CountriesTable.circleSign eq circleSign }
                if (crescentSign != 0) andWhere { CountriesTable.crescentSign eq crescentSign }
                if (crossSign != 0) andWhere { CountriesTable.crossSign eq crossSign }
                if (starSign != 0) andWhere { CountriesTable.starSign eq starSign }
                if (sunSign != 0) andWhere { CountriesTable.sunSign eq sunSign }
                if (otherSign != 0) andWhere { CountriesTable.otherSign eq otherSign }
                if (noSigns != 0) andWhere { CountriesTable.noSigns eq noSigns }
            }.map{ row ->
                CountryDTO(
                    code = row[CountriesTable.id].value,
                    name = row[CountriesTable.name],
                    flagPath = row[CountriesTable.flagPath]
                )
            }
        }
    }*/
}