package com.xxx.MultiThread;
import com.xxx.exception.AuthException;
import com.xxx.exception.CRUDTaskException;
import com.xxx.exception.CastingException;
import com.xxx.exception.NullTaskException;
import com.xxx.model.User;
import com.xxx.service.UserService;

import java.util.Scanner;

public class UserMultiThread extends Thread{

    public User loggedInUser;


    public UserMultiThread(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @Override
    public void run() {
        try {
            loggedInUser.displayMenu();
        } catch (CRUDTaskException e) {
            throw new RuntimeException(e);
        } catch (CastingException e) {
            throw new RuntimeException(e);
        } catch (NullTaskException e) {
            throw new RuntimeException(e);
        }

    }
}
