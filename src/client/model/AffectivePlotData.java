package client.model;

import java.util.ArrayList;
import java.util.Arrays;

public class AffectivePlotData {

    private static volatile AffectivePlotData affectivePlotData;
    private static Object mutex = new Object();
    private ArrayList<Float> interestList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> engagementList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> relaxList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> stressList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<Float> excitmentList = new ArrayList<>(Arrays.asList(0.0f));

	public ArrayList<Float> getFocusList() {
		return focusList;
	}

	public void setFocusList(ArrayList<Float> focusList) {
		this.focusList = focusList;
	}

	private ArrayList<Float> focusList = new ArrayList<>(Arrays.asList(0.0f));
    private ArrayList<ArrayList<Float>> mainDataList = new ArrayList<>();
    
    public ArrayList<ArrayList<Float>> getMainDataList() {
		return mainDataList;
	}

	public ArrayList<Float> getInterestList() {
		return interestList;
	}

	public void setInterestList(ArrayList<Float> interestList) {
		this.interestList = interestList;
	}

	public ArrayList<Float> getEngagementList() {
		return engagementList;
	}

	public void setEngagementList(ArrayList<Float> engagementList) {
		this.engagementList = engagementList;
	}

	public ArrayList<Float> getRelaxList() {
		return relaxList;
	}

	public void setRelaxList(ArrayList<Float> relaxList) {
		this.relaxList = relaxList;
	}

	public ArrayList<Float> getStressList() {
		return stressList;
	}

	public void setStressList(ArrayList<Float> stressList) {
		this.stressList = stressList;
	}

	public ArrayList<Float> getExcitmentList() {
		return excitmentList;
	}

	public void setExcitmentList(ArrayList<Float> excitmentList) {
		this.excitmentList = excitmentList;
	}



	

    public static AffectivePlotData getAffectivePlotData() {
        return affectivePlotData;
    }

    public static AffectivePlotData getInstance() {
        AffectivePlotData result = affectivePlotData;
        if (result == null) {
            synchronized (mutex) {
                result = affectivePlotData;
                if (result == null)
                    result = new AffectivePlotData();
                affectivePlotData = result;
            }
        }
        return result;
    }
    
    public void setDataToList(AffectiveData affectivedata) {
		focusList.add(affectivedata.getFocus());
    	interestList.add(affectivedata.getInterest());
    	engagementList.add(affectivedata.getEngagement());
    	stressList.add(affectivedata.getStress());
    	relaxList.add(affectivedata.getRelaxation());
    	excitmentList.add(affectivedata.getExcitement());
    	mainDataList.clear();
		mainDataList.add(focusList);
		mainDataList.add(stressList);
    	mainDataList.add(interestList);
    	mainDataList.add(engagementList);
    	mainDataList.add(relaxList);
    	mainDataList.add(excitmentList);

    	
    }
}
