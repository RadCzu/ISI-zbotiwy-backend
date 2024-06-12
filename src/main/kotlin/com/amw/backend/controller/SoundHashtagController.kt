package com.amw.backend.controller

import com.amw.backend.model.SoundHashtag
import com.amw.backend.repository.SoundHashtagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/hashtagsounds")
@CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200", ))
class SoundHashtagController {

    @Autowired
    private val soundHashtagRepository: SoundHashtagRepository? = null

    @GetMapping
    fun getAllSoundHashtags(): List<SoundHashtag?> {
        return soundHashtagRepository!!.findAll()
    }

    @PostMapping
    fun createSoundHashtag(@RequestBody soundHashtag: SoundHashtag): SoundHashtag {
        return soundHashtagRepository!!.save(soundHashtag)
    }

    @GetMapping("/{id}")
    fun getSoundHashtagById(@PathVariable id: String): SoundHashtag {
        return soundHashtagRepository!!.findById(id).orElse(null)!!
    }

    @PutMapping("/{id}")
    fun updateSoundHashtag(@PathVariable id: String?, @RequestBody soundHashtag: SoundHashtag): SoundHashtag {
        soundHashtag.setId(id)
        return soundHashtagRepository!!.save(soundHashtag)
    }

    @DeleteMapping("/{id}")
    fun deleteSoundHashtag(@PathVariable id: String) {
        soundHashtagRepository!!.deleteById(id)
    }
}