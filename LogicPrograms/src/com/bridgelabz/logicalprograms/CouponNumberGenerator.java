/**CouponNumberGenerator is implementing the coupon numbers
 * @author kishorereddy
 * @version 1.0
 * @since 03-02-2020
 * @file CouponNumberGenerator.java
 */
package com.bridgelabz.logicalprograms;

public class CouponNumberGenerator {
    
	//main method to start execution
	public static void main(String[] args) {
		Utility util = new Utility();
		String couponCode="ABCDEFGHIJKLMN1234567890";
		char[] charactersOfCoupon=couponCode.toCharArray();
		System.out.println(util.couponCodeGenerator(charactersOfCoupon));
	}
}

