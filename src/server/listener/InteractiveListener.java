package server.listener;

/*
 * Interface for Interactive Panel
 */
public interface InteractiveListener {
	
	
    public void autoResetChange(String stateValue);
    
    public void stateSpinnerChange(boolean isSelected);

}
