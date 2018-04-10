package server.listener;

/**
 *
 */
public interface InteractiveListener {

    public void autoResetChange(String stateValue);

    public void stateSpinnerChange(boolean isSelected);

}
