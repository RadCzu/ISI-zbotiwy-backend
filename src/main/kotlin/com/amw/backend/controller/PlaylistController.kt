package com.amw.backend.controller

import com.amw.backend.model.Playlist
import com.amw.backend.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/playlist")
@CrossOrigin(origins = arrayOf("http://localhost:4200", "http://192.168.88.120:4200", "http://192.168.88.69:4200"))
class PlaylistController {
    @Autowired
    private val playlistRepository: PlaylistRepository? = null

    @get:GetMapping
    val allPlaylists: List<Playlist?>
        get() = playlistRepository!!.findAll()

    @PostMapping
    fun createPlaylist(@RequestBody playlist: Playlist): Playlist {
        return playlistRepository!!.save(playlist)
    }

    @GetMapping("/{id}")
    fun getPlaylistById(@PathVariable id: String): Playlist {
        return playlistRepository!!.findById(id).orElse(null)!!
    }

    @PutMapping("/{id}")
    fun updatePlaylist(@PathVariable id: String?, @RequestBody playlist: Playlist): Playlist {
        playlist.setId(id)
        return playlistRepository!!.save(playlist)
    }

    @DeleteMapping("/{id}")
    fun deletePlaylist(@PathVariable id: String) {
        playlistRepository!!.deleteById(id)
    }
}