import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Integer> duplicatedElements;
    private int[] numbers = {3,6,4,5,6,6,3,4,7,55,23,5};


    public Application(){
        this.duplicatedElements = new ArrayList<>();
    }


    public void handleApp(){
        findDuplicates();
        sortListOfNumbers();
        System.out.println(duplicatedElements.toString());
    }


    private void findDuplicates(){
        
        for (int number : numbers) {
            int counter = 0;

            for(int i=0; i<numbers.length; i++){
                if (number == numbers[i] && !numberNotInList(number)) {
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
        for (int number : duplicatedElements) {
            for (int i=0; i<duplicatedElements.size()-1; i++) {
                int first = duplicatedElements.get(i);
                int next = duplicatedElements.get(i+1);
                if (first>next) {
                    int temp = first;
                    first = next;
                    next = temp;
                }
            }
        }
    }
    
}