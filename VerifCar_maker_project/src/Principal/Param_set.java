package Principal;

import java.io.Serializable;
import java.util.ArrayList;

import Interface.Car;

public class Param_set implements Serializable{

	private static final long serialVersionUID = 1422449543046132620L;

	int scale;
	int S;
	int L;
	int R;
	int V_min;
	int GranA;
	int W;
	int NormX; //( >= (GranA*S/scale)/2 )
	int nb_lane; //( >= 2 )
	int end_junction; //( <= L )
	int begin_junction; //( <= end_junction )
	ArrayList<Integer> marking; //[nb_lane + 1] ( marking[i] <= marking[i-1] ) to build as a list {posY, ... , posY}
	int nb_car; //( >= 2 )
	int safety_length;
	int safety_width;
	int traj_length;
	int delay_step;
	int max_delay; //(integer multiple of delay_step)
	ArrayList<Car_set> Car_list;

	int navigation_points_max;
	int V_max;
	int A_min;
	int A_max;

	public Param_set(int scale, int s, int l, int r, int v_min, int granA, int w, int normX,
			int nb_lane, int end_junction, int begin_junction, ArrayList<Integer> marking, int nb_car,
			int safety_length, int safety_width, int traj_length, int delay_step, int max_delay,
			ArrayList<Car_set> car_list, int navigation_points_max, int v_max, int a_min, int a_max) {
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
		this.A_max = a_max;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getS() {
		return S;
	}

	public void setS(int s) {
		S = s;
	}

	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	public int getR() {
		return R;
	}

	public void setR(int r) {
		R = r;
	}

	public int getV_min() {
		return V_min;
	}

	public void setV_min(int v_min) {
		V_min = v_min;
	}

	public int getGranA() {
		return GranA;
	}

	public void setGranA(int granA) {
		GranA = granA;
	}

	public int getW() {
		return W;
	}

	public void setW(int w) {
		W = w;
	}

	public int getNormX() {
		return NormX;
	}

	public void setNormX(int normX) {
		NormX = normX;
	}

	public int getNb_lane() {
		return nb_lane;
	}

	public void setNb_lane(int nb_lane) {
		this.nb_lane = nb_lane;
	}

	public int getEnd_junction() {
		return end_junction;
	}

	public void setEnd_junction(int end_junction) {
		this.end_junction = end_junction;
	}

	public int getBegin_junction() {
		return begin_junction;
	}

	public void setBegin_junction(int begin_junction) {
		this.begin_junction = begin_junction;
	}

	public ArrayList<Integer> getMarking() {
		return marking;
	}

	public void setMarking(ArrayList<Integer> marking) {
		this.marking = marking;
	}

	public int getNb_car() {
		return nb_car;
	}

	public void setNb_car(int nb_car) {
		this.nb_car = nb_car;
	}

	public int getSafety_length() {
		return safety_length;
	}

	public void setSafety_length(int safety_length) {
		this.safety_length = safety_length;
	}

	public int getSafety_width() {
		return safety_width;
	}

	public void setSafety_width(int safety_width) {
		this.safety_width = safety_width;
	}

	public int getTraj_length() {
		return traj_length;
	}

	public void setTraj_length(int traj_length) {
		this.traj_length = traj_length;
	}

	public int getDelay_step() {
		return delay_step;
	}

	public void setDelay_step(int delay_step) {
		this.delay_step = delay_step;
	}

	public int getMax_delay() {
		return max_delay;
	}

	public void setMax_delay(int max_delay) {
		this.max_delay = max_delay;
	}

	public ArrayList<Car_set> getCar_list() {
		return Car_list;
	}

	public void setCar_list(ArrayList<Car_set> car_list) {
		Car_list = car_list;
	}

	public int getNavigation_points_max() {
		return navigation_points_max;
	}

	public void setNavigation_points_max(int navigation_points_max) {
		this.navigation_points_max = navigation_points_max;
	}

	public int getV_max() {
		return V_max;
	}

	public void setV_max(int v_max) {
		V_max = v_max;
	}

	public int getA_min() {
		return A_min;
	}

	public void setA_min(int a_min) {
		A_min = a_min;
	}

	public int getA_max() {
		return A_max;
	}

	public void setA_max(int a_max) {
		A_min = a_max;
	}

}
