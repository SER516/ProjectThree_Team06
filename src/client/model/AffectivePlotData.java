package client.model;

import java.util.ArrayList;

public class AffectivePlotData {

    private static volatile AffectivePlotData affectivePlotData;
    private static Object mutex = new Object();
    private ArrayList<Float> interestList = new ArrayList<>();
    private ArrayList<Float> engagementList = new ArrayList<>();
    private ArrayList<Float> relaxList = new ArrayList<>();
    private ArrayList<Float> stressList = new ArrayList<>();
    private ArrayList<Float> excitmentList = new ArrayList<>();
    //private ArrayList<Float> focusList = new ArrayList<>();
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
    	interestList.add(affectivedata.getInterest());
    	engagementList.add(affectivedata.getEngagement());
    	stressList.add(affectivedata.getStress());
    	relaxList.add(affectivedata.getRelaxation());
    	excitmentList.add(affectivedata.getExcitement());
    	//focusList.add(affectivedata.getFocus());
    	mainDataList.clear();
    	mainDataList.add(interestList);
    	mainDataList.add(engagementList);
    	mainDataList.add(stressList);
    	mainDataList.add(relaxList);
    	mainDataList.add(excitmentList);
    	//mainDataList.add(focusList);
    	
    }
}
