public class A4Exercises {

	/*
	 * Purpose: gets the number of buildings in the given list
	 * Parameters: List bList - the list of buildings
	 * Returns: int - the number of buildings in the given list
	 */
	public static int buildingsCount(List bList) {
		return bList.size();
	}
	
	/*
	 * Purpose: gets the total number of inhabitants living 
	 *          in all the buildings in the given list
	 * Parameters: List bList - the list of buildings
	 * Returns: int - the number of inhabitants across all buildings
	 */
	public static int inhabitantsCount(List bList) {
		int sum = 0;
		for (int i = 0; i < bList.size(); i++) {
			sum += bList.get(i).getNumberOfInhabitants();
		}
		return sum;
		}
	
	/*
	 * Purpose: get the number of buildings into the list b is
	 * Parameters: List bList - the list of buildings
	 *             Building b - the building to find
	 * Returns: int - the distance the first occurrence of 
	 *                b is from the start of the list, or 
	 *                -1 if b is not found in bList
	 */
	public static int distanceAway(List bList, Building b) {
		int i = 0;
		if (bList.size() != 0) {
		while (b.getName() != bList.get(i).getName()) {
			i++;
		}
	}
		return i;
	}
	
	/*
	 * Purpose: get the distance the tallest building is 
	 *          from the start of the list
	 * Parameters: List bList - the list of buildings
	 * Returns: int - the distance the tallest building
	 *                is from the start of the list
	 */
	public static int distanceToTallest(List bList) {
		int tallestindex = 0;
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getNumberOfStories() > bList.get(tallestindex).getNumberOfStories()) {
				tallestindex = i;
			}
		}
		return tallestindex;
	}

	/*
	 * Purpose: get the number of buildings visible 
	 *          from the beginning of the list 
	 * Parameters: List bList - the list of buildings
	 * Returns: int - the number of buildings visible
	 * 
	 * Note: Read through the assignment PDF for more information
	 */
	public static int numberVisible(List bList) {
		int visible = 0;
		int curtallest = 0;
		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i).getNumberOfStories() > curtallest) {
				curtallest = bList.get(i).getNumberOfStories();
				visible++;
			}
		}
		return visible;
	}
		


}