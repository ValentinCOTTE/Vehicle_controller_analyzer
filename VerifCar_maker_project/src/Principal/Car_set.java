package Principal;

import java.util.ArrayList;

public class Car_set {
	String length_vehicle;
	String width_vehicle;
	String vmax;
	String amin;
	String amax;
	String ctrfreq;
	String maxcom;
	String mincom;
	String initposx;
	String initposy;
	String initV;
	String initA;
	String navigationpoints;
	
	ArrayList<String> navigation_posX=new ArrayList<String>();
	ArrayList<String> navigation_laneInf=new ArrayList<String>();
	ArrayList<String> navigation_laneSup=new ArrayList<String>();
	
	public String getLength_vehicle() {
		return length_vehicle;
	}

	public void setLength_vehicle(String length_vehicle) {
		this.length_vehicle = length_vehicle;
	}

	public String getWidth_vehicle() {
		return width_vehicle;
	}

	public void setWidth_vehicle(String width_vehicle) {
		this.width_vehicle = width_vehicle;
	}

	public String getVmax() {
		return vmax;
	}

	public void setVmax(String vmax) {
		this.vmax = vmax;
	}

	public String getAmin() {
		return amin;
	}

	public void setAmin(String amin) {
		this.amin = amin;
	}

	public String getAmax() {
		return amax;
	}

	public void setAmax(String amax) {
		this.amax = amax;
	}

	public String getMaxcom() {
		return maxcom;
	}

	public void setMaxcom(String maxcom) {
		this.maxcom = maxcom;
	}

	public String getCtrfreq() {
		return ctrfreq;
	}

	public void setCtrfreq(String ctrfreq) {
		this.ctrfreq = ctrfreq;
	}

	public String getMincom() {
		return mincom;
	}

	public void setMincom(String mincom) {
		this.mincom = mincom;
	}

	public String getInitposx() {
		return initposx;
	}

	public void setInitposx(String initposx) {
		this.initposx = initposx;
	}

	public String getInitV() {
		return initV;
	}

	public void setInitV(String initV) {
		this.initV = initV;
	}

	public String getInitA() {
		return initA;
	}

	public void setInitA(String initA) {
		this.initA = initA;
	}

	public String getInitposy() {
		return initposy;
	}

	public void setInitposy(String initposy) {
		this.initposy = initposy;
	}

	public String getNavigationpoints() {
		return navigationpoints;
	}

	public void setNavigationpoints(String navigationpoints) {
		this.navigationpoints = navigationpoints;
	}

	public ArrayList<String> getNavigation_posX() {
		return navigation_posX;
	}

	public void setNavigation_posX(ArrayList<String> navigation_posX) {
		this.navigation_posX = navigation_posX;
	}

	public ArrayList<String> getNavigation_laneInf() {
		return navigation_laneInf;
	}

	public void setNavigation_laneInf(ArrayList<String> navigation_laneInf) {
		this.navigation_laneInf = navigation_laneInf;
	}

	public ArrayList<String> getNavigation_laneSup() {
		return navigation_laneSup;
	}

	public void setNavigation_laneSup(ArrayList<String> navigation_laneSup) {
		this.navigation_laneSup = navigation_laneSup;
	}

	public Car_set(String length_vehicle, String width_vehicle, String vmax, String amin, String amax, 
			String ctrfreq, String maxcom,String mincom, String initposx, String initposy,String initV, String initA, 
			String navigationpoints, ArrayList<String> navigation_posX, ArrayList<String> navigation_laneInf,
			ArrayList<String> navigation_laneSup) {
		super();
		this.length_vehicle = length_vehicle;
		this.width_vehicle = width_vehicle;
		this.vmax = vmax;
		this.amin = amin;
		this.amax = amax;
		this.ctrfreq = ctrfreq;
		this.maxcom = maxcom;
		this.mincom = mincom;
		this.initposx = initposx;
		this.initposy = initposy;
		this.initV = initV;
		this.initA = initA;
		this.navigationpoints = navigationpoints;
		this.navigation_posX = navigation_posX;
		this.navigation_laneInf = navigation_laneInf;
		this.navigation_laneSup = navigation_laneSup;
	}

}
