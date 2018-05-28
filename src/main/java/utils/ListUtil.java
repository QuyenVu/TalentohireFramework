package utils;

import java.util.*;
import java.util.logging.Logger;

public class ListUtil {
	
	protected Logger logger;
	
	public ListUtil() {
		logger = Logger.getLogger(this.getClass().getName() + "]");
	}

	
	public <T extends Comparable<T>> boolean compareLists(List<T> list, List<T> list2){
		boolean flag = true;
		if(list.size() == list2.size()){

			Collections.sort(list);
			Collections.sort(list2);
			
			
			for(int i=0;i<list.size();i++){
				if(!list.get(i).toString().toUpperCase().trim().equalsIgnoreCase(list2.get(i).toString().toUpperCase().trim())){
					logger.warning("No Match for Element: List1 " + list.get(i));
					flag = false;
					break;
				} 
			}
			System.out.println("list " + list);
			System.out.println("list2" + list2);
			logger.info("Matched All Elements");
		} else {
			flag = false;
		}
		return flag;
	}
	
	public <T extends Comparable<T>> boolean compareLists(List<T> list, List<T> list2, T oldVal, T newVal){
		boolean flag = true;
		if(list.size() == list2.size()){

			replaceListVals(list, oldVal, newVal);
			replaceListVals(list2, oldVal, newVal);
			
			Collections.sort(list);
			Collections.sort(list2);
			
			for(int i=0;i<list.size();i++){
				//if(!list.get(i).equals(list2.get(i))){
				if(!list.get(i).toString().toUpperCase().trim().equalsIgnoreCase(list2.get(i).toString().toUpperCase().trim())){
					logger.warning("No Match for Element: List1 " + list.get(i));
					flag = false;
					break;
				} 
			}
			System.out.println("list " + list);
			System.out.println("list2" + list2);
			logger.info("Matched All Elements");
		} else {
			flag = false;
		}
		return flag;
	}
	
	public <T extends Comparable<T>> void replaceListVals(List<T> list, T oldVal, T newVal){
		Collections.replaceAll(list, oldVal, newVal);
	}

}
