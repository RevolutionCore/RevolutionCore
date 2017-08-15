package me.evanog.revolution;

public abstract class Manager {

	
	public abstract void enable();

	
	public abstract void disable();

	
	public Core getCore() {
		return Core.getInstance();
	}

}
