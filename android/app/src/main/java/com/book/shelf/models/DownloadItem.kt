package com.book.shelf.models

import com.book.shelf.data.LocalFolder
import com.book.shelf.data.MediaProgress
import com.book.shelf.data.MediaType
import com.fasterxml.jackson.annotation.JsonIgnore

data class DownloadItem(
  val id: String,
  val libraryItemId:String,
  val episodeId:String?,
  val userMediaProgress: MediaProgress?,
  val serverConnectionConfigId:String,
  val serverAddress:String,
  val serverUserId:String,
  val mediaType: String,
  val itemFolderPath:String,
  val localFolder: LocalFolder,
  val itemTitle: String,
  val itemSubfolder: String,
  val media: MediaType,
  val downloadItemParts: MutableList<DownloadItemPart>
) {
  @get:JsonIgnore
  val isInternalStorage get() = localFolder.id.startsWith("internal-")

  @get:JsonIgnore
  val isDownloadFinished get() = !downloadItemParts.any { !it.completed || it.isMoving }

  @JsonIgnore
  fun getNextDownloadItemParts(limit:Int): MutableList<DownloadItemPart> {
    val itemParts = mutableListOf<DownloadItemPart>()
    if (limit == 0) return itemParts

    for (it in downloadItemParts) {
      if (!it.completed && it.downloadId == null) {
        itemParts.add(it)
        if (itemParts.size >= limit) break
      }
    }

    return itemParts
  }
}
