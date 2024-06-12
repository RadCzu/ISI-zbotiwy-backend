package com.amw.backend.controller

import com.amw.backend.model.Keyword
import com.amw.backend.repository.KeywordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/keywords")
@CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200"))
class KeywordController {
    @Autowired
    private val keywordRepository: KeywordRepository? = null

    @get:GetMapping
    val allKeywords: List<Keyword?>
        get() = keywordRepository!!.findAll()

    @PostMapping
    fun createKeyword(@RequestBody keyword: Keyword): Keyword {
        return keywordRepository!!.save(keyword)
    }

    @GetMapping("/{id}")
    fun getKeywordById(@PathVariable id: String): Keyword {
        return keywordRepository!!.findById(id).orElse(null)!!
    }

    @PutMapping("/{id}")
    fun updateKeyword(@PathVariable id: String?, @RequestBody keyword: Keyword): Keyword {
        keyword.setId(id)
        return keywordRepository!!.save(keyword)
    }

    @DeleteMapping("/{id}")
    fun deleteKeyword(@PathVariable id: String) {
        keywordRepository!!.deleteById(id)
    }
}