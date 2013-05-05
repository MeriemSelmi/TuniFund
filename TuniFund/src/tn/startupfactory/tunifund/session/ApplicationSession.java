package tn.startupfactory.tunifund.session;



public class ApplicationSession {
	private static ApplicationSession appSess;
	private int id;
	private ApplicationSession(){
		id = -1;
	}

    public static ApplicationSession getInstance(){
    	if(appSess == null){
    		appSess = new ApplicationSession();
    		return appSess;
    	}
    	else{
    		
    		return appSess;
    	}
    	
    }

	public int getSession() {
		return id;
	}

	public void setSession(int session) {
		this.id = id;
	}

}
