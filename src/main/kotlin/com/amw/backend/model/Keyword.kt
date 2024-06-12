package com.amw.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "keywords")
class Keyword {
    @Id
    private var id: String? = null
    private val keyword: String? = null

    public fun setId(id: String?) {
        this.id = id
    }
}