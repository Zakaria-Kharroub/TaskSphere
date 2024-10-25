package org.example.scheduler;

import org.example.domaine.User;
import org.example.service.UserService;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TokenScheduler {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private final UserService userService = new UserService();
    public void startScheduler(){
        scheduler.scheduleAtFixedRate(this::checkAndUpdateTokenDelete, 0, 30, TimeUnit.DAYS);
        scheduler.scheduleAtFixedRate(this::checkAndUpdateTokenResingne,0,1,TimeUnit.DAYS);
    }

    private void checkAndUpdateTokenDelete(){
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if (user.getTokenDelete() < 1) {
                while (user.getTokenDelete() < 1) {
                    user.setTokenDelete(user.getTokenDelete() + 1);
                    userService.updateUser(user);
                }
            }
        }
    }
    private void checkAndUpdateTokenResingne(){
        List<User> users = userService.getAllUsers();
        for (User user :users){
            if (user.getTokenResingne()<2){
                while (user.getTokenResingne()<2){
                    user.setTokenResingne(user.getTokenResingne()+2);
                    userService.updateUser(user);
                }
            }
        }
    }



}
