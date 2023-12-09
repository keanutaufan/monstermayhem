package events;

import java.util.ArrayList;

import airdrop.AirdropTypes;

public class AirdropCycle {

	private ArrayList<AirdropTypes> airdropList;
	
	public AirdropCycle(ArrayList<AirdropTypes> airdropList) {
		this.airdropList = airdropList;
	}
	
	public ArrayList<AirdropTypes> getAirdropList() {
		return airdropList;
	}
	
}
