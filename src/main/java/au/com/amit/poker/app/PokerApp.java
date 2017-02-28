/**
 * 
 */
package au.com.amit.poker.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import au.com.amit.poker.domain.service.PokerService;

/**
 * @author Amit Solankurkar
 *
 */
public class PokerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader br = null;

        try{
            br = new BufferedReader(new InputStreamReader(System.in));
			PokerService pokerService = new PokerService();
			pokerService.calculateRanking(br);
        } catch (Exception e) {
			System.err.println("Invalid input");
			System.exit(1);
        } 
	}
}
