//package com.university.repo;
//
//public class MainClass {
//
//	public static void main(String[] args) {
//		boolean state = true;
//		do {
//			Mobile moblist = new Mobile();
//			moblist.displayMobiles();
//			int user;
//			com.mk.util.Options.ao1();
//			user = scan.nextInt();
//			switch (user) {
//			case 1:{
//				int akey;
//				do {
//					switch (akey) {
//					case 1:
//						Admin.viewTotalCustomers();
//						break;
//					case 2:
//						Admin.addMobile();
//						break;
//					case 3:
//						Admin.viewMobileStock();
//						break;
//					case 4:
//						Admin.getMobileSpecification();
//						break;
//					case 5:
//						Admin.generateInvoice();
//						break;
//					case 6:
//						Admin.viewInvoice();
//						break;
//					case 7:
//						Clear.screen(45);
//						break;
//					default:
//						System.out.println("Invalid Choice");
//						break;
//					case 0:
//						akey = 0;
//						break;
//					}
//				} while (akey != 0);
//
//			}break;
//			case 2:{
//				System.out.println("shop keeper");
//
//
//
//			}break;
//			case 3:{
//				System.out.println("Stock Incharger");
//
//
//
//			}break;
//			case 4:{
//				Clear.screen(45);
//				System.out.println("Do you want to EXIT...? \nEnter your choice (y or n)");
//				boolean warning = true;
//				String warnchoice = scan.next();
//				while(warning) {
//					switch (warnchoice) {
//					case "y":{
//						warning = false;
//						mainpower = false;
//					}break;
//					case "n":warning = false;
//					break;
//					default:{
//						System.out.println("invalid choice");
//						warnchoice = scan.next();
//					}break;
//					}
//				}
//			}break;
//
//			default:System.out.println("Invalid Option");
//			break;
//			}
//		} while (state);
//		System.out.println("Power off");
//	}
//}
//
