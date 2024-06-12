package com.amw.backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "soundpieces")
class SoundPiece {
    @Id
    private var id: String? = null
    private var title: String? = null
    private var author: String? = null
    private var link: String? = null
    private var pictureLink: String? = null
    private var listenCount: Number? = null

    constructor(
        id: String?,
        title: String?,
        author: String?,
        link: String?,
        pictureLink: String?,
        listenCount: Number?
    ) {
        this.id = id
        this.title = title
        this.author = author
        this.link = link
        this.pictureLink = pictureLink
        this.listenCount = listenCount
    }

    public fun setId(id: String?) {
        this.id = id
    }

    public fun setTitle(title: String?) {
        this.title=title
    }

    public fun setAuthor(author: String?) {
        this.author=author
    }

    public fun setLink(link: String?) {
        this.link=link
    }

    public fun setPictureLink(pictureLink: String?) {
        this.pictureLink=pictureLink
    }

    public fun setListenCount(count: Number?) {
        this.listenCount = count
    }

    public fun getId(): String? {return this.id}

    public fun getTitle(): String? {return this.title}

    public fun getAuthor(): String? {return this.author}

    public fun getLink(): String? {return this.link}

    public fun getPictureLink(): String? {return this.pictureLink}

    public fun getListenCount(): Number? {return this.listenCount}

}