package Principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Interface.Param;

public class Param_writer {
	Param_writer(Param param){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("parameters")));
			
			String save="scale="+param.getScale()
					+"S="
					+"L="
					+"R="
					+"V_min="
					+"GranA="
					+"W="
					+"NormX="
					+"nb_lane="
					+"end_junction="
					+"begin_junction="
					+"marking[nb_lane + 1] ( marking[i] <= marking[i-1] ) to build as a list {0,(posY1*scale)/(W*S), ... , (posYn*scale)/(W*S),(R*scale)/(W*S)}"
					+"nb_car="
					+"safety_length="
					+"safety_width="
					+"traj_length="
					+"delay_step="
					+"max_delay="
					+""
					+""
					+"List of vehicle param (one by vehicle) :"
					+ ""
					+"length_vehicle"
					+"width_vehicle"
					+"v_max ( >= V_min )"
					+"a_min ( can be negative )"
					+"a_max ( >= a_min )"
					+"ctr_freq ( > S )"
					+"max_com ( < ctr_freq )"
					+"min_com ( < max_com )"
					+"init_posX ( <= L )"
					+"init_posY ( <= R )"
					+"init_V ( >= V_min && <= v_max )"
					+"init_A ( >= a_min && <= a_max )"
					+"navigation_points ( >= 1 )"
					+"navigation_list[navigation_points][3] to build as a list of list {{0,lane(inf),lane(sup)},{(posX*scale)/(NormX*S),lane(inf),lane(sup)}, ... , {(L*scale)/(NormX*S),lane(inf),lane(sup)}}" 
					+""
					+"Constants to calculate :"
					+""
					+"V_max ( max v_max from vehicle param )"
					+"A_min ( min a_min from vehicle param )"
					+"A_max ( max a_max from vehicle param )";
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
