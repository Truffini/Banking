package trevor.RAP.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class main{
	
	private static final Logger LOG = LogManager.getLogger(main.class);
	
	public static void main(String[] args) {
		
		LOG.trace("Started main method");
		
		Controller.init();
		
		LOG.trace("Ended main method");
	}
}