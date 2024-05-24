package com.book.shelf.models

import com.book.shelf.data.MediaProgress
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
  val id:String,
  val username: String,
  val mediaProgress:List<MediaProgress>
)
