package com.victor.magalums.dto;

import com.victor.magalums.domain.Channel;
import com.victor.magalums.domain.Notification;
import com.victor.magalums.domain.Status;

import java.time.LocalDateTime;

public record SheduleNotificationDTO(LocalDateTime dateTime,
                                     String destination,
                                     String message,
                                     Channel.Values channel) {

    public Notification toNotification(){
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
