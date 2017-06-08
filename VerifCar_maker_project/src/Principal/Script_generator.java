package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Interface.Param;

public class Script_generator {
	Param_set param;
	int scale;
	int S;
	int L;
	int R;
	int V_min;
	int GranA;
	int W;
	int NormX;
	int nb_lane;
	int end_junction;
	int begin_junction;
	ArrayList<Integer> marking;
	int nb_car;
	int safety_length;
	int safety_width;
	int traj_length;
	int delay_step;
	int max_delay;

	ArrayList<Car_set> Car_list;
	int[] length_vehicle;
	int[] width_vehicle;
	int[] vmax;
	int[] amin;
	int[] amax;
	int[] ctrfreq;
	int[] maxcom;
	int[] mincom;
	int[] initposx;
	int[] initposy;
	int[] initV;
	int[] STEP_initV;
	int[] LIMIT_initV;
	int[] initA;
	int[] STEP_initA;
	int[] LIMIT_initA;
	int[] navigationpoints;
	ArrayList<Integer>[] navigation_posX;
	ArrayList<Integer>[] navigation_laneInf;
	ArrayList<Integer>[] navigation_laneSup;


	int navigation_points_max;
	int V_max;
	int A_min;
	int A_max;

	public Script_generator(Param_set param){
		this.param=param;

		this.scale=param.getScale();
		this.S=param.getS();
		this.L=param.getL();
		this.R=param.getR();
		this.V_min=param.getV_min();
		this.GranA=param.getGranA();
		this.W=param.getW();
		this.NormX=param.getNormX();
		this.nb_lane=param.getNb_lane();
		this.end_junction=param.getEnd_junction();
		this.begin_junction=param.getBegin_junction();
		this.marking=param.getMarking();
		this.nb_car=param.getNb_car();
		this.safety_length=param.getSafety_length();
		this.safety_width=param.getSafety_width();
		this.traj_length=param.getTraj_length();
		this.delay_step=param.getDelay_step();
		this.max_delay=param.getMax_delay();
		this.Car_list=param.getCar_list();

		this.length_vehicle=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.length_vehicle[i]=Car_list.get(i).getLength_vehicle();
		}
		this.width_vehicle=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.width_vehicle[i]=Car_list.get(i).getWidth_vehicle();
		}
		this.vmax=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.vmax[i]=Car_list.get(i).getVmax();
		}
		this.amin=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.amin[i]=Car_list.get(i).getAmin();
		}
		this.amax=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.amax[i]=Car_list.get(i).getAmax();
		}
		this.ctrfreq=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.ctrfreq[i]=Car_list.get(i).getCtrfreq();
		}
		this.maxcom=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.maxcom[i]=Car_list.get(i).getMaxcom();
		}
		this.mincom=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.mincom[i]=Car_list.get(i).getMincom();
		}
		this.initposx=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.initposx[i]=Car_list.get(i).getInitposx();
		}
		this.initposy=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.initposy[i]=Car_list.get(i).getInitposy();
		}
		this.initV=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.initV[i]=Car_list.get(i).getInitV();
		}
		this.STEP_initV=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.STEP_initV[i]=Car_list.get(i).getSTEP_initV();
		}
		this.LIMIT_initV=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.LIMIT_initV[i]=Car_list.get(i).getLIMIT_initV();
		}
		this.initA=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.initA[i]=Car_list.get(i).getInitA();
		}
		this.STEP_initA=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.STEP_initA[i]=Car_list.get(i).getSTEP_initA();
		}
		this.LIMIT_initA=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.LIMIT_initA[i]=Car_list.get(i).getLIMIT_initA();
		}
		this.navigationpoints=new int[nb_car];
		for(int i=0;i<nb_car;i++){
			this.navigationpoints[i]=Car_list.get(i).getNavigationpoints();
		}
		this.navigation_posX=new ArrayList[nb_car];
		for(int i = 0 ; i < nb_car ; i++){
			navigation_posX[i] = Car_list.get(i).getNavigation_posX();
		}
		this.navigation_laneInf=new ArrayList[nb_car];
		for(int i = 0 ; i < nb_car ; i++){
			navigation_laneInf[i] = Car_list.get(i).getNavigation_laneInf();
		}
		this.navigation_laneSup=new ArrayList[nb_car];
		for(int i = 0 ; i < nb_car ; i++){
			navigation_laneSup[i]= Car_list.get(i).getNavigation_laneSup();
		}

		this.navigation_points_max=param.getNavigation_points_max();
		this.V_max=param.getV_max();
		this.A_min=param.getA_min();
		this.A_max=param.getA_max();


		try {
			File file =new File("tmp_script.sh");
			file.setExecutable(true);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			String SCRIPT="#!/bin/sh\n";






			if(nb_car==1){
				for(initV[0]=param.getCar_list().get(0).getInitV();initV[0]<=param.getCar_list().get(0).getLIMIT_initV();initV[0]+=param.getCar_list().get(0).getSTEP_initV()){
					for(initA[0]=param.getCar_list().get(0).getInitA();initA[0]<=param.getCar_list().get(0).getLIMIT_initA();initA[0]+=param.getCar_list().get(0).getSTEP_initA()){
						SCRIPT+=writeCycle();
					}
					initA[0]=param.getCar_list().get(0).getInitA();
				}
				initV[0]=param.getCar_list().get(0).getInitV();
			}

			if(nb_car==2){
				for(initV[0]=param.getCar_list().get(0).getInitV();initV[0]<=param.getCar_list().get(0).getLIMIT_initV();initV[0]+=param.getCar_list().get(0).getSTEP_initV()){
					for(initV[1]=param.getCar_list().get(1).getInitV();initV[1]<=param.getCar_list().get(1).getLIMIT_initV();initV[1]+=param.getCar_list().get(1).getSTEP_initV()){
						for(initA[0]=param.getCar_list().get(0).getInitA();initA[0]<=param.getCar_list().get(0).getLIMIT_initA();initA[0]+=param.getCar_list().get(0).getSTEP_initA()){
							for(initA[1]=param.getCar_list().get(1).getInitA();initA[1]<=param.getCar_list().get(1).getLIMIT_initA();initA[1]+=param.getCar_list().get(1).getSTEP_initA()){
								SCRIPT+=writeCycle();
							}
							initA[1]=param.getCar_list().get(1).getInitA();
						}
						initA[0]=param.getCar_list().get(0).getInitA();
					}
					initV[1]=param.getCar_list().get(1).getInitV();
				}
				initV[0]=param.getCar_list().get(0).getInitV();
			}

			if(nb_car==3){
				for(initV[0]=param.getCar_list().get(0).getInitV();initV[0]<=param.getCar_list().get(0).getLIMIT_initV();initV[0]+=param.getCar_list().get(0).getSTEP_initV()){
					for(initV[1]=param.getCar_list().get(1).getInitV();initV[0]<=param.getCar_list().get(1).getLIMIT_initV();initV[1]+=param.getCar_list().get(1).getSTEP_initV()){
						for(initV[2]=param.getCar_list().get(2).getInitV();initV[2]<=param.getCar_list().get(2).getLIMIT_initV();initV[2]+=param.getCar_list().get(2).getSTEP_initV()){
							for(initA[0]=param.getCar_list().get(0).getInitA();initA[0]<=param.getCar_list().get(0).getLIMIT_initA();initA[0]+=param.getCar_list().get(0).getSTEP_initA()){
								for(initA[1]=param.getCar_list().get(1).getInitA();initA[1]<=param.getCar_list().get(1).getLIMIT_initA();initA[1]+=param.getCar_list().get(1).getSTEP_initA()){
									for(initA[2]=param.getCar_list().get(2).getInitA();initA[2]<=param.getCar_list().get(2).getLIMIT_initA();initA[2]+=param.getCar_list().get(2).getSTEP_initA()){
										SCRIPT+=writeCycle();
									}
									initA[2]=param.getCar_list().get(2).getInitA();
								}
								initA[1]=param.getCar_list().get(1).getInitA();
							}
							initA[0]=param.getCar_list().get(0).getInitA();
						}
						initV[2]=param.getCar_list().get(2).getInitV();
					}
					initV[1]=param.getCar_list().get(1).getInitV();
				}
				initV[0]=param.getCar_list().get(0).getInitV();
			}

			if(nb_car==4){
				for(initV[0]=param.getCar_list().get(0).getInitV();initV[0]<=param.getCar_list().get(0).getLIMIT_initV();initV[0]+=param.getCar_list().get(0).getSTEP_initV()){
					for(initV[1]=param.getCar_list().get(1).getInitV();initV[0]<=param.getCar_list().get(1).getLIMIT_initV();initV[1]+=param.getCar_list().get(1).getSTEP_initV()){
						for(initV[2]=param.getCar_list().get(2).getInitV();initV[2]<=param.getCar_list().get(2).getLIMIT_initV();initV[2]+=param.getCar_list().get(2).getSTEP_initV()){
							for(initV[3]=param.getCar_list().get(3).getInitV();initV[3]<=param.getCar_list().get(3).getLIMIT_initV();initV[3]+=param.getCar_list().get(3).getSTEP_initV()){
								for(initA[0]=param.getCar_list().get(0).getInitA();initA[0]<=param.getCar_list().get(0).getLIMIT_initA();initA[0]+=param.getCar_list().get(0).getSTEP_initA()){
									for(initA[1]=param.getCar_list().get(1).getInitA();initA[1]<=param.getCar_list().get(1).getLIMIT_initA();initA[1]+=param.getCar_list().get(1).getSTEP_initA()){
										for(initA[2]=param.getCar_list().get(2).getInitA();initA[2]<=param.getCar_list().get(2).getLIMIT_initA();initA[2]+=param.getCar_list().get(2).getSTEP_initA()){
											for(initA[3]=param.getCar_list().get(3).getInitA();initA[3]<=param.getCar_list().get(3).getLIMIT_initA();initA[3]+=param.getCar_list().get(3).getSTEP_initA()){
												SCRIPT+=writeCycle();
											}
											initA[3]=param.getCar_list().get(3).getInitA();
										}
										initA[2]=param.getCar_list().get(2).getInitA();
									}
									initA[1]=param.getCar_list().get(1).getInitA();
								}
								initA[0]=param.getCar_list().get(0).getInitA();
							}
							initV[3]=param.getCar_list().get(3).getInitV();
						}
						initV[2]=param.getCar_list().get(2).getInitV();
					}
					initV[1]=param.getCar_list().get(1).getInitV();
				}
				initV[0]=param.getCar_list().get(0).getInitV();
			}


			SCRIPT+="exit 0\n";
			writer.write(SCRIPT);
			writer.close();
			Runtime.getRuntime().exec("chmod 777 tmp_script.sh");


			System.out.println("tmp_script uploaded");
		}
		catch (IOException e){
			System.out.println("error: can't create tmp_script.sh");
			e.printStackTrace();
		}

		String[] cmd = { "/bin/sh", "tmp_script.sh" };
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.getOutputStream().close();
            p.getInputStream().close();
	      } catch (IOException e) {
	          System.out.println("error: can't execute tmp_script.sh");
	    	  e.printStackTrace();
	      }

	}

	public String writeCycle(){
		String part="java -jar Generator.jar "+scale
				+" "+S
				+" "+L
				+" "+R
				+" "+V_min
				+" "+V_max
				+" "+A_min
				+" "+A_max
				+" "+GranA
				+" "+W
				+" "+NormX
				+" "+length_vehicle[0] //MISE à JOUR???
				+" "+width_vehicle[0]  //MISE à JOUR???
				+" "+begin_junction
				+" "+end_junction
				+" "+nb_lane;

				for(int i=0;i<marking.size();i++){
					part+=" "+marking.get(i);
				}

				part+=" "+nb_car
						+" "+ctrfreq[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+ctrfreq[i];
				}
				part+=" "+mincom[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+mincom[i];
				}
				part+=" "+maxcom[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+maxcom[i];
				}
				part+=" "+initposx[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+initposx[i];
				}
				part+=" "+initposy[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+initposy[i];
				}
				part+=" "+initV[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+initV[i];
				}
				part+=" "+initA[0];

				for(int i=1;i<nb_car;i++){
					part+=" "+initA[i];
				}
				part+=" "+navigation_points_max
				+" "+navigation_posX[0].get(0)
				+" "+navigation_laneInf[0].get(0)
				+" "+navigation_laneSup[0].get(0);

				for(int i=1;i<navigation_points_max;i++){
					part+=" "+navigation_posX[0].get(i)
							+" "+navigation_laneInf[0].get(i)
							+" "+navigation_laneSup[0].get(i);
				}
						;
				for(int car=1;car<nb_car;car++){
					part+=" "+navigation_posX[car].get(0)
							+" "+navigation_laneInf[car].get(0)
							+" "+navigation_laneSup[car].get(0);
					for(int i=1;i<navigation_points_max;i++){
						part+=" "+navigation_posX[car].get(i)
								+" "+navigation_laneInf[car].get(i)
								+" "+navigation_laneSup[car].get(i);
					}
				}
				part+=" "+safety_length
				+" "+safety_width
				+" "+traj_length
				+" "+delay_step
				+" "+max_delay
				+"\n";
				part+="echo Formal verification with queries.q ...\n"
				+"./verifyta -q -s new_VerifCar.xml resources/queries.q >> Tests.txt\n"
				+"echo File Tests.txt done\n"
				+"\n";
				return part;
	}
}
