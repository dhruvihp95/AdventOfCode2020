package src.star_7_8;

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class PassportProcessing {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(".\\Input\\input4.csv");
		Scanner sc = new Scanner(file);
		int correctPassports = 0;
		Passport passport = new Passport();
		while(sc.hasNextLine()) {
			String ip = sc.nextLine();
			if(!ip.isEmpty()) {
				String[] ips = ip.split(" ");
				setValues(ips,passport);
			} else {
				if(isPassportValid(passport)) {
					correctPassports++;
				}
				passport = new Passport();
			}
		}
		if(isPassportValid(passport)) {
			correctPassports++;
		}
		System.out.println(correctPassports);
	}
	
	private static boolean isPassportValid(Passport passport) {
		return (passport.getByr() != null && validateByr(passport.getByr())) &&
				(passport.getEcl() != null && validateEcl(passport.getEcl())) &&
				(passport.getEyr() != null && validateEyr(passport.getEyr())) &&
				(passport.getHcl() != null && validateHcl(passport.getHcl())) &&
				(passport.getHgt() != null && validateHgt(passport.getHgt())) &&
				(passport.getIyr() != null && validateIyr(passport.getIyr())) &&
				(passport.getPid() != null && validatePid(passport.getPid()));
	}

	private static boolean validatePid(String pid) {
		return Pattern.matches("[0-9]{9}",pid);
	}

	private static boolean validateIyr(Integer iyr) {
		return iyr >= 2010 && iyr <=2020;
	}

	private static boolean validateHgt(String hgt) {
		if(hgt.endsWith("cm")) {
			int ht = Integer.parseInt(hgt.substring(0, hgt.indexOf("cm")));
			return ht>=150 && ht<=193;
		} else if(hgt.endsWith("in")) {
			int ht = Integer.parseInt(hgt.substring(0, hgt.indexOf("in")));
			return ht>=59 && ht<=76;
		}
		return false;
	}

	private static boolean validateHcl(String hcl) {
		return Pattern.matches("[#]{1}[a-f0-9]{6}",hcl);
	}

	private static boolean validateEyr(Integer eyr) {
		return eyr >= 2020 && eyr <=2030;
	}

	private static boolean validateEcl(String ecl) {
		switch(ecl) {
			case "amb":
			case "blu":
			case "brn":
			case "gry":
			case "grn":
			case "hzl":
			case "oth": return true;
		}
		return false;
	}

	private static boolean validateByr(Integer byr) {
		return byr >= 1920 && byr <=2002;
	}

	
	private static void setValues(String[] ips, Passport passport) {
		for(String kv:ips) {
			String[] keyValue = kv.split(":");
			setKeyValue(keyValue,passport);
		}
		
	}

	private static void setKeyValue(String[] keyValue, Passport passport) {
		switch(keyValue[0]) {
			case "byr" : passport.setByr(Integer.parseInt(keyValue[1]));
						break;
			case "iyr" : passport.setIyr(Integer.parseInt(keyValue[1]));
						break;
			case "eyr" : passport.setEyr(Integer.parseInt(keyValue[1]));
						break;
			case "hgt" : passport.setHgt(keyValue[1]);
						break;
			case "hcl" : passport.setHcl(keyValue[1]);
						break;
			case "ecl" : passport.setEcl(keyValue[1]);
						break;
			case "pid" : passport.setPid(keyValue[1]);
						break;
			case "cid" : passport.setCid(keyValue[1]);
						break;			
		}
		
	}

	private static class Passport {
		Integer byr;
		Integer iyr;
		Integer eyr;
		String hgt;
		String hcl;
		String ecl;
		String pid;
		String cid;
		
		public Passport() {
			super();
		}

		public Integer getByr() {
			return byr;
		}

		public void setByr(int byr) {
			this.byr = byr;
		}

		public Integer getIyr() {
			return iyr;
		}

		public void setIyr(int iyr) {
			this.iyr = iyr;
		}

		public Integer getEyr() {
			return eyr;
		}

		public void setEyr(int eyr) {
			this.eyr = eyr;
		}

		public String getHgt() {
			return hgt;
		}

		public void setHgt(String hgt) {
			this.hgt = hgt;
		}

		public String getHcl() {
			return hcl;
		}

		public void setHcl(String hcl) {
			this.hcl = hcl;
		}

		public String getEcl() {
			return ecl;
		}

		public void setEcl(String ecl) {
			this.ecl = ecl;
		}

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		public String getCid() {
			return cid;
		}

		public void setCid(String cid) {
			this.cid = cid;
		}
		
		
	}

}
