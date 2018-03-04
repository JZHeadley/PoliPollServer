package com.jzheadley.polipoll.server.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MessagingId(
        @Id
        var messagingId: String? = null)