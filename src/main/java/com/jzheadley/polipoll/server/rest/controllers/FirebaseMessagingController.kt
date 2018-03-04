package com.jzheadley.polipoll.server.rest.controllers

import com.jzheadley.polipoll.server.models.Bill
import com.jzheadley.polipoll.server.models.payloads.BillPayload
import com.jzheadley.polipoll.server.repositories.MessagingIdRepository
import de.bytefish.fcmjava.client.FcmClient
import de.bytefish.fcmjava.model.options.FcmMessageOptions
import de.bytefish.fcmjava.requests.data.DataMulticastMessage
import de.bytefish.fcmjava.requests.notification.NotificationPayload
import de.bytefish.fcmjava.responses.FcmMessageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration

@RestController
class FirebaseMessagingController(private val messagingIdRepo: MessagingIdRepository, private val fcmClient: FcmClient) {
//
//    @PostMapping("messagingIds")
//    fun storeMessagingId(@RequestBody messagingId: String) {
//        messagingIdRepo.save(MessagingId(messagingId))
//    }

    @GetMapping("test/messagingIds/send")
    fun testNotificationSending() {
        sendNotifsOfCheckInToFollowersOfUser(Bill(15, "Could Florida had a law allowing authorities to confiscate weapons from people",
                "https://www.gpo.gov/fdsys/pkg/BILLS-115hr2598ih/pdf/BILLS-115hr2598ih.pdf"))
    }

    private fun sendNotifsOfCheckInToFollowersOfUser(bill: Bill) {
        val messageOptions = FcmMessageOptions.builder()
                .setTimeToLive(Duration.ofHours(1))
                .build()
        val messagingingIds: List<String?> = messagingIdRepo.findAll().map { obj -> obj.messagingId }
        val notification = DataMulticastMessage(messageOptions,
                messagingingIds,
                BillPayload(bill),
                NotificationPayload.builder()
                        .setClickAction("BILL_ADDED_NOTIF")
                        .setBody("Could Florida had a law allowing authorities to confiscate weapons from people")
                        .setTitle("New Bill!")
                        .build())
        val response: FcmMessageResponse = fcmClient.send(notification)
        println("FCM Message Response:\t" + response)
    }

}