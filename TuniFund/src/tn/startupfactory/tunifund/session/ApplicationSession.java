package tn.startupfactory.tunifund.session;

import android.app.Application;

public class ApplicationSession extends Application{
	
	Session session = new Session();

    public String getId() {
        return session.id;
    }

    public void setId(String username) {
        session.id = username;
    }

}
