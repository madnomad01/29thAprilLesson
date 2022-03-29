import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class App {

    public static void fillList(List<Smartphone> list) {
        list.add(new Smartphone("Samsung Galaxy1", 200, 2010, 16, Color.BLACK, 6.2));
        list.add(new Smartphone("Samsung Galaxy2", 250, 2011, 32, Color.WHITE, 5.5));
        list.add(new Smartphone("Samsung Galaxy3", 300, 2012, 64, Color.GRAY, 4.7));
        list.add(new Smartphone("Samsung Galaxy4", 350, 2013, 64, Color.BLACK, 5.0));
        list.add(new Smartphone("Samsung Galaxy5", 400, 2014, 16, Color.WHITE, 5.8));
        list.add(new Smartphone("Samsung Galaxy6", 450, 2015, 16, Color.GRAY, 5.2));
        list.add(new Smartphone("Samsung Galaxy7", 500, 2016, 32, Color.BLACK, 5.7));
        list.add(new Smartphone("Samsung Galaxy8", 550, 2017, 64, Color.WHITE, 4.0));
        list.add(new Smartphone("Samsung Galaxy9", 600, 2018, 64, Color.GRAY, 6.0));
        list.add(new Smartphone("Samsung Galaxy10", 650, 2019, 128, Color.WHITE, 5.1));
        list.add(new Smartphone("Iphone 1", 300, 2010, 16, Color.GRAY, 6.2));
        list.add(new Smartphone("Iphone 2", 350, 2011, 16, Color.WHITE, 5.5));
        list.add(new Smartphone("Iphone 3", 400, 2012, 16, Color.GRAY, 4.7));
        list.add(new Smartphone("Iphone 4", 450, 2013, 32, Color.BLACK, 5.0));
        list.add(new Smartphone("Iphone 5", 500, 2014, 32, Color.WHITE, 6.1));
        list.add(new Smartphone("Iphone 6", 550, 2015, 64, Color.BLACK, 6.2));
        list.add(new Smartphone("Iphone 7", 600, 2016, 128, Color.ROSE, 5.5));
        list.add(new Smartphone("Iphone 8", 650, 2017, 128, Color.GOLD, 4.7));
        list.add(new Smartphone("Iphone 9", 700, 2018, 128, Color.GOLD, 5.5));
        list.add(new Smartphone("Iphone 10", 750, 2019, 128, Color.ROSE, 5.8));
    }

    public static void main(String[] args) throws Exception {
        List<Smartphone> list = new ArrayList<>();
        fillList(list);

        System.out.println("1-st AllMatch smartphone memory size is more than 15. Returns true");
        boolean allMatch = list.stream()
                            .allMatch((t) -> t.getMemorySize() > 15);
        System.out.println(allMatch);
        System.out.println();

        System.out.println("2-nd AnyMatch is there a smartphone with RED colour. Returns false");
        boolean anyMatch = list.stream()
                            .anyMatch((t) -> t.getColor() == Color.RED);
        System.out.println(anyMatch);
        System.out.println();

        System.out.println("3-rd noneMatch there is no Redmi smartphone. Returns true");
        boolean noneMatch = list.stream()
                            .noneMatch((t) -> t.getName().toLowerCase().contains("redmi"));
        System.out.println(noneMatch);
        System.out.println();

        System.out.println("4-th Most expensive smartphone");
        Smartphone expensiveSmartphone = list.stream()
                            .max(Comparator.comparing(Smartphone::getPrice))
                            .orElseThrow(NoSuchElementException::new);
        System.out.println(expensiveSmartphone);
        System.out.println();

        System.out.println("5-th Cheapest smartphone");
        Smartphone cheapestSmartphone = list.stream()
                            .min(Comparator.comparing(Smartphone::getPrice))
                            .orElseThrow(NoSuchElementException::new);
        System.out.println(cheapestSmartphone);
        System.out.println();

        System.out.println("6-th and 7-th Sort by price And Print");
        List<Smartphone> sortedList = list.stream()
                                        .sorted(Comparator.comparing(Smartphone::getPrice))
                                        .collect(Collectors.toList());
        sortedList.stream()
            .forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("8-th Print products from Samsung");
        List<Smartphone> samsungSmartphones = list.stream()
                            .filter(e -> e.getName().toLowerCase().contains("samsung"))
                            .collect(Collectors.toList());
        samsungSmartphones.stream()
                            .forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("9-th Print smartphones with screen size more than 6.0 inch");
        List<Smartphone> screenSizeSmartphones = list.stream()
                            .filter(e -> e.getDiagonalScreenSize() > 6.0)
                            .collect(Collectors.toList());
        screenSizeSmartphones.stream()
                            .forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("10-th Print smartphones released in 2010");
        List<Smartphone> releasedSmartphones = list.stream()
                            .filter(e -> e.getReleaseYear() == 2010)
                            .collect(Collectors.toList());
        releasedSmartphones.stream()
                            .forEach(e -> System.out.println(e));
        System.out.println();


        System.out.println("11-th Convert list to array");
        Smartphone[] smartphones = list.stream()
                                .toArray(Smartphone[]::new);
        Arrays.stream(smartphones).forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("12-th Distinct diagonal screen sizes");
        List<Double> allScreenSizes = list.stream()
                            .map(Smartphone::getDiagonalScreenSize)
                            .collect(Collectors.toList());
        List<Double> distinctScreenSizes = allScreenSizes.stream()
                                        .distinct()
                                        .collect(Collectors.toList());
        System.out.println(distinctScreenSizes);
        System.out.println();

        System.out.println("13-th Top-3 most expensive smartphones");
        int s = sortedList.size();
        sortedList.subList(s-3, s).forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("14-th Print smartphones released after 2016");
        List<Smartphone> releasedAfterSmartphones = list.stream()
                            .filter(e -> e.getReleaseYear() > 2016)
                            .collect(Collectors.toList());
        releasedAfterSmartphones.stream()
                            .forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("15-th Increment prices by 500");
        List<Smartphone> pricesIncremented = list.stream()
                            .peek(e -> e.setPrice(e.getPrice() + 500))
                            .collect(Collectors.toList());
        pricesIncremented.stream()
                            .forEach(e -> System.out.println(e));
        System.out.println();

        System.out.println("16-th Average price");
        Double avgPrice = list.stream()
                            .mapToDouble(Smartphone::getPrice)
                            .average()
                            .orElseThrow(NoSuchElementException::new);
        System.out.println(avgPrice);
        System.out.println();

        System.out.println("17-th Reversed sort by price");
        List<Smartphone> reverseSortedList = list.stream()
                                        .sorted(Comparator.comparing(Smartphone::getPrice))
                                        .collect(Collectors.toList());
        Collections.reverse(sortedList);
        sortedList.stream()
            .forEach(e -> System.out.println(e));
        System.out.println();
    }
}
