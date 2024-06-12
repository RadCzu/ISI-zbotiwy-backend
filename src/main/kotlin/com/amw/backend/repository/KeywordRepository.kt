package com.amw.backend.repository

import com.amw.backend.model.Keyword
import org.springframework.data.mongodb.repository.MongoRepository

interface KeywordRepository : MongoRepository<Keyword?, String?>