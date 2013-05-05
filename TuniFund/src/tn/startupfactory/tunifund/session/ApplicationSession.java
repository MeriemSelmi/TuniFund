package tn.startupfactory.tunifund.session;

import android.app.Application;


public class ApplicationSession {
	
	public static Session session;
	public ApplicationSession(){
		session = new Session();
	}

    public static String getId() {
        return session.id;
    }

    public void setId(String username) {
        session.id = username;
    }

}
