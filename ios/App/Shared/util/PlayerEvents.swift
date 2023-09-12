//
//  PlayerEvents.swift
//  App
//
//  Created by Rasmus Krämer on 14.04.22.
//

import Foundation

enum PlayerEvents: String {
    case update = "com.book.shelf.player.update"
    case closed = "com.book.shelf.player.closed"
    case sleepSet = "com.book.shelf.player.sleep.set"
    case sleepEnded = "com.book.shelf.player.sleep.ended"
    case failed = "com.book.shelf.player.failed"
    case localProgress = "com.book.shelf.player.localProgress"
}
