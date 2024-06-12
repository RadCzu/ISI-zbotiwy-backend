package com.amw.backend.repository

import com.amw.backend.model.SoundHashtag
import org.springframework.data.mongodb.repository.MongoRepository

interface SoundHashtagRepository : MongoRepository<SoundHashtag?, String?>