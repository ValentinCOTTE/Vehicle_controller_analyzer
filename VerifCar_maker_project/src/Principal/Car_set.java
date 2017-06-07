package Principal;

import java.io.Serializable;
import java.util.ArrayList;

public class Car_set implements Serializable{
	int length_vehicle;
	int width_vehicle;
	int vmax;
	int amin;
	int amax;
	int ctrfreq;
	int maxcom;
	int mincom;
	int initposx;
	int initposy;
	int initV;
	int STEP_initV;
	int LIMIT_initV;
	int initA;
	int STEP_initA;
	int LIMIT_initA;
	int navigationpoints;

	ArrayList<Integer> navigation_posX=new ArrayList<Integer>();
	ArrayList<Integer> navigation_laneInf=new ArrayList<Integer>();
	ArrayList<Integer> navigation_laneSup=new ArrayList<Integer>();


	public Car_set(int length_vehicle, int width_vehicle, int vmax, int amin, int amax,
			int ctrfreq, int maxcom,int mincom, int initposx, int initposy,int initV, int STEP_initV,
			int LIMIT_initV, int initA, int STEP_initA, int LIMIT_initA, int navigationpoints, ArrayList<Integer> navigation_posX, ArrayList<Integer> navigation_laneInf,
			ArrayList<Integer> navigation_laneSup) {
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
		this.STEP_initV=STEP_initV;
		this.LIMIT_initV=LIMIT_initV;

		this.initA = initA;
		this.STEP_initA=STEP_initA;
		this.LIMIT_initA=LIMIT_initA;

		this.navigationpoints = navigationpoints;
		this.navigation_posX = navigation_posX;
		this.navigation_laneInf = navigation_laneInf;
		this.navigation_laneSup = navigation_laneSup;
	}


	public int getLength_vehicle() {
		return length_vehicle;
	}

	public void setLength_vehicle(int length_vehicle) {
		this.length_vehicle = length_vehicle;
	}

	public int getWidth_vehicle() {
		return width_vehicle;
	}

	public void setWidth_vehicle(int width_vehicle) {
		this.width_vehicle = width_vehicle;
	}

	public int getVmax() {
		return vmax;
	}

	public void setVmax(int vmax) {
		this.vmax = vmax;
	}

	public int getAmin() {
		return amin;
	}

	public void setAmin(int amin) {
		this.amin = amin;
	}

	public int getAmax() {
		return amax;
	}

	public void setAmax(int amax) {
		this.amax = amax;
	}

	public int getMaxcom() {
		return maxcom;
	}

	public void setMaxcom(int maxcom) {
		this.maxcom = maxcom;
	}

	public int getCtrfreq() {
		return ctrfreq;
	}

	public void setCtrfreq(int ctrfreq) {
		this.ctrfreq = ctrfreq;
	}

	public int getMincom() {
		return mincom;
	}

	public void setMincom(int mincom) {
		this.mincom = mincom;
	}

	public int getInitposx() {
		return initposx;
	}

	public void setInitposx(int initposx) {
		this.initposx = initposx;
	}

	public int getInitV() {
		return initV;
	}

	public void setInitV(int initV) {
		this.initV = initV;
	}

	public int getInitA() {
		return initA;
	}

	public void setInitA(int initA) {
		this.initA = initA;
	}

	public int getInitposy() {
		return initposy;
	}

	public void setInitposy(int initposy) {
		this.initposy = initposy;
	}

	public int getNavigationpoints() {
		return navigationpoints;
	}

	public void setNavigationpoints(int navigationpoints) {
		this.navigationpoints = navigationpoints;
	}

	public ArrayList<Integer> getNavigation_posX() {
		return navigation_posX;
	}

	public void setNavigation_posX(ArrayList<Integer> navigation_posX) {
		this.navigation_posX = navigation_posX;
	}

	public ArrayList<Integer> getNavigation_laneInf() {
		return navigation_laneInf;
	}

	public void setNavigation_laneInf(ArrayList<Integer> navigation_laneInf) {
		this.navigation_laneInf = navigation_laneInf;
	}

	public ArrayList<Integer> getNavigation_laneSup() {
		return navigation_laneSup;
	}

	public void setNavigation_laneSup(ArrayList<Integer> navigation_laneSup) {
		this.navigation_laneSup = navigation_laneSup;
	}

	public int getSTEP_initV() {
		return STEP_initV;
	}

	public void setSTEP_initV(int sTEP_initV) {
		STEP_initV = sTEP_initV;
	}

	public int getLIMIT_initV() {
		return LIMIT_initV;
	}

	public void setLIMIT_initV(int lIMIT_initV) {
		LIMIT_initV = lIMIT_initV;
	}

	public int getSTEP_initA() {
		return STEP_initA;
	}

	public void setSTEP_initA(int sTEP_initA) {
		STEP_initA = sTEP_initA;
	}

	public int getLIMIT_initA() {
		return LIMIT_initA;
	}

	public void setLIMIT_initA(int lIMIT_initA) {
		LIMIT_initA = lIMIT_initA;
	}

}
