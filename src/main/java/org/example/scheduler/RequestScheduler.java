package org.example.scheduler;

import org.example.domaine.Request;
import org.example.domaine.RequestStatus;
import org.example.domaine.User;
import org.example.service.RequestService;
import org.example.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RequestScheduler {

    public final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final RequestService requestService = new RequestService();
    private final UserService userService = new UserService();

    public void startSchedular(){
        scheduler.scheduleAtFixedRate(this::checkAndUpdateTokens,0,1, TimeUnit.HOURS);

    }

    public void checkAndUpdateTokens(){
        List<Request> requests = requestService.getAllRequests();
        for (Request request : requests) {
            if (request.getStatus().equals(RequestStatus.PENDING) && request.getCreated_at().isBefore(LocalDateTime.now().minusHours(12).toLocalDate())) {
                User user = request.getUser();
                user.setTokenResingne(user.getTokenResingne() *2 );
                userService.updateUser(user);
                request.setStatus(RequestStatus.EXPIRED);
                requestService.updateRequest(request);

            }
        }
    }

}
