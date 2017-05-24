package Principal;

import java.io.Serializable;
import java.util.ArrayList;

import Interface.Car;

public class Param_set implements Serializable{
	
	private static final long serialVersionUID = 1422449543046132620L;
	
	String scale;
	String S;
	String L;
	String R;
	String V_min;
	String GranA;
	String W;
	String NormX; //( >= (GranA*S/scale)/2 )
	String nb_lane; //( >= 2 )
	String end_junction; //( <= L )
	String begin_junction; //( <= end_junction )
	ArrayList<String> marking; //[nb_lane + 1] ( marking[i] <= marking[i-1] ) to build as a list {posY, ... , posY}
	String nb_car; //( >= 2 )
	String safety_length;
	String safety_width;
	String traj_length;
	String delay_step;
	String max_delay; //(integer multiple of delay_step)
	ArrayList<Car_set> Car_list;
	
	String navigation_points_max;
	String V_max;
	String A_min;
	
	public Param_set(String scale, String s, String l, String r, String v_min, String granA, String w, String normX,
			String nb_lane, String end_junction, String begin_junction, ArrayList<String> marking, String nb_car,
			String safety_length, String safety_width, String traj_length, String delay_step, String max_delay,
			ArrayList<Car_set> car_list, String navigation_points_max, String v_max, String a_min) {
		super();
		this.scale = scale;
		this.S = s;
		this.L = l;
		this.R = r;
		this.V_min = v_min;
		this.GranA = granA;
		this.W = w;
		this.NormX = normX;
		this.nb_lane = nb_lane;
		this.end_junction = end_junction;
		this.begin_junction = begin_junction;
		this.marking = marking;
		this.nb_car = nb_car;
		this.safety_length = safety_length;
		this.safety_width = safety_width;
		this.traj_length = traj_length;
		this.delay_step = delay_step;
		this.max_delay = max_delay;
		this.Car_list = car_list;
		this.navigation_points_max = navigation_points_max;
		this.V_max = v_max;
		this.A_min = a_min;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getS() {
		return S;
	}

	public void setS(String s) {
		S = s;
	}

	public String getL() {
		return L;
	}

	public void setL(String l) {
		L = l;
	}

	public String getR() {
		return R;
	}

	public void setR(String r) {
		R = r;
	}

	public String getV_min() {
		return V_min;
	}

	public void setV_min(String v_min) {
		V_min = v_min;
	}

	public String getGranA() {
		return GranA;
	}

	public void setGranA(String granA) {
		GranA = granA;
	}

	public String getW() {
		return W;
	}

	public void setW(String w) {
		W = w;
	}

	public String getNormX() {
		return NormX;
	}

	public void setNormX(String normX) {
		NormX = normX;
	}

	public String getNb_lane() {
		return nb_lane;
	}

	public void setNb_lane(String nb_lane) {
		this.nb_lane = nb_lane;
	}

	public String getEnd_junction() {
		return end_junction;
	}

	public void setEnd_junction(String end_junction) {
		this.end_junction = end_junction;
	}

	public String getBegin_junction() {
		return begin_junction;
	}

	public void setBegin_junction(String begin_junction) {
		this.begin_junction = begin_junction;
	}

	public ArrayList<String> getMarking() {
		return marking;
	}

	public void setMarking(ArrayList<String> marking) {
		this.marking = marking;
	}

	public String getNb_car() {
		return nb_car;
	}

	public void setNb_car(String nb_car) {
		this.nb_car = nb_car;
	}

	public String getSafety_length() {
		return safety_length;
	}

	public void setSafety_length(String safety_length) {
		this.safety_length = safety_length;
	}

	public String getSafety_width() {
		return safety_width;
	}

	public void setSafety_width(String safety_width) {
		this.safety_width = safety_width;
	}

	public String getTraj_length() {
		return traj_length;
	}

	public void setTraj_length(String traj_length) {
		this.traj_length = traj_length;
	}

	public String getDelay_step() {
		return delay_step;
	}

	public void setDelay_step(String delay_step) {
		this.delay_step = delay_step;
	}

	public String getMax_delay() {
		return max_delay;
	}

	public void setMax_delay(String max_delay) {
		this.max_delay = max_delay;
	}

	public ArrayList<Car_set> getCar_list() {
		return Car_list;
	}

	public void setCar_list(ArrayList<Car_set> car_list) {
		Car_list = car_list;
	}

	public String getNavigation_points_max() {
		return navigation_points_max;
	}

	public void setNavigation_points_max(String navigation_points_max) {
		this.navigation_points_max = navigation_points_max;
	}

	public String getV_max() {
		return V_max;
	}

	public void setV_max(String v_max) {
		V_max = v_max;
	}

	public String getA_min() {
		return A_min;
	}

	public void setA_min(String a_min) {
		A_min = a_min;
	}

}
