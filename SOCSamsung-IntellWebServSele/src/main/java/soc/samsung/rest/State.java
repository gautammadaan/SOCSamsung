package soc.samsung.rest;

import soc.samsung.dto.*;
import soc.samsung.po.serviceTrustPO;
import soc.samsung.context.UserContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class State {
	public HashMap<String, List<Point>> verifyPoints;
	public HashMap<String, HashMap<StreetSegment, List<Integer>>> underEvaluation;
	public List<serviceTrustPO> serviceTrust;
	public Random randomGenerator;
	public UserContext context;
	private static State instance = null;
	
	protected State() {
		// Exists only to defeat instantiation.
   }
	
	public static State getInstance(){
		if (instance == null) {
			instance = new State();
			
			instance.verifyPoints = new HashMap<String, List<Point>>();
			instance.underEvaluation = new HashMap<String, HashMap<StreetSegment, List<Integer>>>();
			instance.serviceTrust = new ArrayList<serviceTrustPO>();
			instance.context = new UserContext();
			
			/* Hard-coded services */
			serviceTrustPO bingService = new serviceTrustPO();
			bingService.setServiceUrl("http://dev.virtualearth.net/REST/V1/Routes/Driving");
			bingService.setServiceTrustValue(0);
			bingService.setServiceName("Bing");
			serviceTrustPO mapquestService = new serviceTrustPO();
			mapquestService.setServiceUrl("http://open.mapquestapi.com/directions/v2/route");
			mapquestService.setServiceTrustValue(0);
			mapquestService.setServiceName("MapQuest");
			serviceTrustPO googleService = new serviceTrustPO();
			googleService.setServiceUrl("http://maps.googleapis.com/maps/api/directions/output");
			googleService.setServiceTrustValue(0);
			googleService.setServiceName("Google");
			
			instance.serviceTrust.add(bingService);
			instance.serviceTrust.add(mapquestService);
			instance.serviceTrust.add(googleService);

			System.out.println(instance.serviceTrust.toString());
			
		}
		return instance;
	}
}