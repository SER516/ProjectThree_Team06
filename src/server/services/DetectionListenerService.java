package server.services;

import server.listener.DetectionListenerInterface;
import server.model.ServerModelSingleton;

import server.view.ServerView;

public class DetectionListenerService implements DetectionListenerInterface{
	ServerView serverView;
	@Override
	public void changeCounter(double counter) {
		serverView.changeClockCounter(counter);
		
	}
	
	public void setServerView(ServerView serverView) {
		this.serverView = serverView;
	}

	public void changeLowerface(String exp,float val) 
	{
		resetLowerface();
		if(exp=="Smile")
        {
			ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmile(val);
        }
        if(exp=="Clench")
        {
        	ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setClench(val);
            }
        if(exp=="Smirk Left")
        {
        	ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(val);
        }   
        if(exp=="Smirk Right")
        {
        	ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(val);
        }
        if(exp=="Laugh")
        {
        	ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(val);
        }		
	}
	
	public void changeUpperface(String exp,float val) 
	{
		resetUpperface();
		if(exp=="Raise Brow")
        {
            ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(val);
        }
		if(exp=="Furrow Brow")
        {
        	ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(val);
        }
		
	}
	
	public void changePerformanceMatrics(String exp,float val) 
	{
		resetPerformanceMetrics();
		if(exp.equals("Interest"))
        {
			ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setInterest(val);
        }
        if(exp.equals("Engagement"))
        {
        	ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setEngagement(val);
            }
        if(exp.equals("Stress"))
        {
        	ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setStress(val);
            }
        if(exp.equals("Relaxation"))
        {
        	ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(val);
        }
        if(exp.equals("Excitement Focus"))
        {
        	ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setExcitement(val);
        }
		
	}
	
	public void changeEye(String eye)
	{
		resetEye();
		
        	if(eye=="Blink")
        	{
        		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setBlink(true);
            }
        	if(eye=="Wink Left")
        	{
        		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(true);
            }
        	if(eye=="Wink Right")
        	{
        		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(true);
            }
        	if(eye=="Look Left")
        	{
        		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(true);
            }
        	if(eye=="Look Right")
        	{
        		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(true);
        	}
        
        
	  }
	
		

	
	public void resetEye()
	{
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setBlink(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkLeft(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setWinkRight(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookLeft(false);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLookRight(false);
      
	}
	
	public void resetUpperface()
	{
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setRaiseBrow(0);
        ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setFurrowBrow(0);
	}
	
	public void resetLowerface()
	{
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmile(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setClench(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkLeft(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setSmirkRight(0);
		ServerModelSingleton.getInstance().getFaceData().getExpressiveData().setLaugh(0);
    }
	
	public void resetPerformanceMetrics()
	{
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setInterest(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setEngagement(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setStress(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setRelaxation(0);
		ServerModelSingleton.getInstance().getFaceData().getAffectiveData().setExcitement(0);    	
	}

}
