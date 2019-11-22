package echalenge;

public class Machine {

	private String machineName;
	private String os;
	private String diskSize;
	private String memory;
	private MachineState machineState;

	public Machine(String machineName, String os, String diskSize, String memory) {
		super();
		this.machineName = machineName;
		this.os = os;
		this.diskSize = diskSize;
		this.memory = memory;
		this.machineState = MachineState.inactive;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public MachineState getMachineState() {
		return machineState;
	}

	public void setMachineState(MachineState machineState) {
		this.machineState = machineState;
	}

	@Override
	public String toString() {
		return this.machineName +":"+ this.machineState;
	}
	
}
