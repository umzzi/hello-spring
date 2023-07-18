package hello.hellospring.ramda;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class CompareTest {

    @Test
    public void compareTest(){
        String first = "johyunhae";
        String second = "hyunhae";
        String[] strArrays = {first, second};

        LengthComparator lc = new LengthComparator();
        System.out.println(lc.compare(first, second));

        Arrays.sort(strArrays, String::compareToIgnoreCase);
        Arrays.stream(strArrays).forEach( s -> System.out.println(s));



    }


    @Test
    public void streamTest(){
        String[] strArrays = {"aaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbBB", "cccccccccccccccC"};
        long count = Arrays.stream(strArrays).filter(w -> w.length() > 12).count();
        System.out.println(count);
    }

    class LengthComparator implements Comparator<String>{
        public int compare(String first, String second){
            return Integer.compare(first.length(), second.length());
        }
    }


    @Test
    public void streamCreationTest(){
        Stream<String> song = Stream.of("gently", "down", "the", "stream");

        Stream<String> silence = Stream.empty();

        Stream<String> echos = Stream.generate(() -> "Echo");

        Stream<Double> randoms = Stream.generate(Math::random);
        System.out.println(randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO , n -> BigInteger.ONE);
    }

    @Test
    public void streamMapTest(){
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
//        randoms.forEach(System.out::println);

        System.out.println("============+");
        Stream<Double> longNumber = randoms.filter(number -> number >= 0.5);
        longNumber.forEach(System.out::println);
    }

    @Test
    public void streamTransformingTest(){
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        uniqueWords.forEach(System.out::println);

        String[] words = {"Hello", "World", "Java example", "Stream"};
        Stream<String> longestFirst = Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed());
        longestFirst.forEach(System.out::println);

    }
}
