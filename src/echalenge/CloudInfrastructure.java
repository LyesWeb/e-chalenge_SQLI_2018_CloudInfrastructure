package echalenge;

import java.util.ArrayList;
import java.util.List;

public class CloudInfrastructure {

	private List<Store> listStores;
	private List<Machine> listMachines;
	
	public CloudInfrastructure() {
		this.listStores = new ArrayList<Store>();
		this.listMachines = new ArrayList<Machine>();
	}
	
	public void createStore(String storeName) {
		Store neededStore = findStoreByName(storeName);
		if(neededStore==null)
			this.listStores.add(new Store(storeName));
		else throw new CreateStoreException();
	}
	
	public void deleteStore(String storeName) {
		Store neededStore = findStoreByName(storeName);
		this.listStores.remove(neededStore);
	}
	
	public void emptyStore(String storeName) {
		Store neededStore = findStoreByName(storeName);
		neededStore.setDocuments(new ArrayList<>());
	}
	
	public Store findStoreByName(String storeName) {
		return this.listStores.stream().filter(store -> storeName.equals(store.getStoreName())).findAny().orElse(null);
	}
	
	public void uploadDocument(String storeName, String ...files) {
		Store neededStore = findStoreByName(storeName);
		for(String fileName: files) {
			neededStore.addDocument(fileName);
		}
	}
	
	public String listStores() {
		String str = "";
		int i = 0;
		for(Store store: this.listStores) {
			str += store.toString();
			if(i!=this.listStores.size()-1)
				str += "||";
			i++;
		}
		return str;
	}
	
	public Machine findMachineByName(String machineName) {
		return this.listMachines.stream().filter(machine -> machineName.equals(machine.getMachineName())).findAny().orElse(null);
	}
	
	public void createMachine(String machineName, String os, String diskSize, String memory) {
		this.listMachines.add(new Machine(machineName, os, diskSize, memory));
	}
	
	public void startMachine(String machineName) {
		Machine neededMachine = findMachineByName(machineName);
		if(neededMachine.getMachineState()!=MachineState.running) neededMachine.setMachineState(MachineState.running);
		else throw new MachineStateException();
	}
	
	public double usedMemory(String machineName) {
		Machine neededMachine = findMachineByName(machineName);
		if(neededMachine.getMachineState()==MachineState.inactive || neededMachine.getMachineState()==MachineState.stopped) return 0;
		else return Double.parseDouble(neededMachine.getMemory().substring(0, neededMachine.getDiskSize().length()-3));
	}
	
	public double usedDisk(String name) {
		Machine neededMachine = findMachineByName(name);
		if(neededMachine!=null) {
			return Integer.parseInt(neededMachine.getDiskSize().substring(0, neededMachine.getDiskSize().length()-2));
		}else {
			Store neededStore = findStoreByName(name);
			return neededStore.getDocuments().size() * 0.1;
		}
	}
	
	public double globalUsedDisk() {
		double total = 0;
		for(Store store:this.listStores) {
			total+=store.getDocuments().size() * 0.1;
		}
		for(Machine machine:this.listMachines) {
			total+=Double.parseDouble(machine.getDiskSize().substring(0, machine.getDiskSize().length()-2));
		}
		return total;
	}

	
	public double globalUsedMemory() {
		double total = 0;
		for(Machine machine:this.listMachines) {
			if(machine.getMachineState()!=MachineState.inactive && machine.getMachineState()!=MachineState.stopped)
				total+=Double.parseDouble(machine.getMemory().substring(0, machine.getMemory().length()-2));
		}
		return total;
	}
	
	public void stopMachine(String machineName) {
		Machine neededMachine = findMachineByName(machineName);
		neededMachine.setMachineState(MachineState.stopped);
	}
	
	public String listMachines() {
		String str = "";
		int i = 0;
		for(Machine machine: this.listMachines) {
			str += machine.toString();
			if(i!=this.listMachines.size()-1)
				str += "||";
			i++;
		}
		return str;
	}
	
}
