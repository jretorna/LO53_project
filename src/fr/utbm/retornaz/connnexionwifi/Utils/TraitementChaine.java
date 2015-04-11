package fr.utbm.retornaz.connnexionwifi.Utils;

public class TraitementChaine {
	public static boolean isAnIp(final String ip) {
		if (ip.matches("^\\d{1,3}(\\."
				+ "(\\d{1,3}(\\.(\\d{1,3}(\\.(\\d{1,3})?)?)?)?)?)?")) {
			return true;
		}
		return false;
	}

	public static boolean isANumber(final String nb) {
		try {
			int nbToCheck = Integer.parseInt(nb);
			if (nbToCheck > 0 && nbToCheck < 9999)
				return true;
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
}
