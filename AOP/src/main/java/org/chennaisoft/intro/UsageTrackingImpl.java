/**
 * 
 */
package org.chennaisoft.intro;

import org.springframework.stereotype.Service;

/**
 * @author surendra
 *
 */
@Service
public class UsageTrackingImpl implements UsageTracking {
	
	/* (non-Javadoc)
	 * @see org.chennaisoft.service.UsageTracking#showUsage()
	 */
	@Override
	public void showUsage() {
		System.out.println("this is system usage introduction.....");
	}

}
