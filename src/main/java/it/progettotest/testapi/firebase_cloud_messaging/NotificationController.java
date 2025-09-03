package it.progettotest.testapi.firebase_cloud_messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class NotificationController {
    @Autowired
    private FCMService fcmService;

    @PostMapping("/notification")
    public ResponseEntity<NotificationResponse> sendNotification(@RequestBody NotificationRequest request) throws ExecutionException, InterruptedException {
        fcmService.sendMessageToToken(request);
        return new ResponseEntity<>(new NotificationResponse(HttpStatus.OK.value(), "La notifica è stata inviata"), HttpStatus.OK);
    }

    @PostMapping("/notification/allusers")
    public ResponseEntity<NotificationResponse> sendNotificationToAll(@RequestBody NotificationRequest request) throws ExecutionException, InterruptedException {
        fcmService.sendMessageToTopic(request);
        return new ResponseEntity<>(new NotificationResponse(HttpStatus.OK.value(), "La notifica è stata inviata a tutti"), HttpStatus.OK);
    }

}
