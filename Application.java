import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Integer> duplicatedElements;
    private int[] numbers = {3,6,4,5,6,6,3,4,7,55,23,55,5};


    public Application(){
        this.duplicatedElements = new ArrayList<>();
    }


    public void handleApp(){
        findDuplicates();
        sortListOfNumbers();
        String convertedList = convertToString();
        System.out.println(convertedList);
    }


    private void findDuplicates(){
        
        for (int number : numbers) {
            int counter = 0;

            for(int i=0; i<numbers.length; i++){
                if (number == numbers[i] && numberNotInList(number)) {
                    counter++;
                }
            }

            if (counter>1) {
                duplicatedElements.add(number);
            }
        }

    }


    private boolean numberNotInList(int number){
        if (duplicatedElements.contains(number)) {
            return false;
        } else {
            return true;
        }
    }


    private void sortListOfNumbers(){
        for (int index=0;index<duplicatedElements.size(); index++) {

            for (int i=0; i<duplicatedElements.size()-1; i++) {
                if (duplicatedElements.get(i) > duplicatedElements.get(i+1)) {
                    int first = duplicatedElements.get(i);
                    int next = duplicatedElements.get(i+1);
                    duplicatedElements.set(i, next);
                    duplicatedElements.set(i+1, first);
                }
            }
        }
    }


    private String convertToString(){
        StringBuilder sb = new StringBuilder();
        for (int number : duplicatedElements) {
            sb.append(number);
            sb.append(",");
        }
        return sb.toString();
    }
    
}