package com.jzheadley.polipoll.server.rest.controllers

import com.jzheadley.polipoll.server.models.Bill
import com.jzheadley.polipoll.server.models.MessagingId
import com.jzheadley.polipoll.server.repositories.MessagingIdRepository
import de.bytefish.fcmjava.client.FcmClient
import de.bytefish.fcmjava.model.options.FcmMessageOptions
import de.bytefish.fcmjava.requests.data.DataMulticastMessage
import de.bytefish.fcmjava.requests.notification.NotificationPayload
import de.bytefish.fcmjava.responses.FcmMessageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.sql.Date
import java.time.Duration

class FirebaseMessagingController(private val messagingIdRepo: MessagingIdRepository, private val fcmClient: FcmClient) {

    @PostMapping("messagingIds")
    fun storeMessagingId(@RequestBody messagingId: String) {
        messagingIdRepo.save(MessagingId(messagingId))
    }

    @GetMapping("messagingId/send")
    fun testNotificationSending() {
        sendNotifsOfCheckInToFollowersOfUser(Bill(1, "blah this is a bill summary", Date(1997, 7, 23),
                "https://code.tutsplus.com/tutorials/how-to-get-started-with-push-notifications-on-android--cms-25870"))
    }

    private fun sendNotifsOfCheckInToFollowersOfUser(bill: Bill) {
        val messageOptions = FcmMessageOptions.builder()
                .setTimeToLive(Duration.ofHours(1))
                .build()
        val messagingingIds: List<String> = messagingIdRepo.findAll().map { obj -> obj.messagingId }
        val notification = DataMulticastMessage(messageOptions,
                messagingingIds,
                bill,
                NotificationPayload.builder()
                        .setClickAction("BILL_ADDED_NOTIF")
                        .setBody("A new bill has been proposed!")
                        .setTitle("New Bill!")
                        .build())
        val response: FcmMessageResponse = fcmClient.send(notification)
        println("FCM Message Response:\t" + response)
    }

}