public class Main {
    public static void main(String[] args) {

        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        String [] arrayStrings = new String[]{"1", "2", "3", "4", "5"};

        ArrayIterator<Integer> integerIterator = new ArrayIterator<>(array);
        ArrayIterator<String> stringIterator = new ArrayIterator<>(arrayStrings);

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }
}
