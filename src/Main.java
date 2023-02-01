import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Float> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 250; i++) {
            randomNumbers.add(new Random().nextFloat() * 1000);
        }

        System.out.println(Arrays.toString(randomNumbers.toArray()));

        randomNumbers = Quicksort(randomNumbers);

        System.out.println(Arrays.toString(randomNumbers.toArray()));
    }

    public static ArrayList<Float> Quicksort(ArrayList<Float> unsortedList) {
        if (unsortedList.size() <= 1) {
            return unsortedList;
        }

        Float pivot = unsortedList.get(0);
        unsortedList.remove(pivot);
        ArrayList<Float> smallerThan = new ArrayList<>();
        ArrayList<Float> equalTo = new ArrayList<>();
        ArrayList<Float> largerThan = new ArrayList<>();

        for (Float f : unsortedList) {
            if (f > pivot) {
                largerThan.add(f);
            } else if (f < pivot) {
                smallerThan.add(f);
            } else if (f.equals(pivot)) {
                equalTo.add(f);
            }
        }

        ArrayList<Float> result = new ArrayList<>(Quicksort(smallerThan));
        result.addAll(equalTo);
        result.add(pivot);
        result.addAll(Quicksort(largerThan));

        return result;
    }
}
