import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println("Количество несовершеннолетних:");
        long count = persons.stream()
                .filter(Person -> Person.getAge() < 18)
                .count();
        System.out.println(count);

        System.out.println("Cписок фамилий призывников (мужчин от 18 и до 27 лет):");
        List<String> list = persons.stream()
                .filter(Person-> Person.getAge() > 18 && Person.getAge() < 27)
                .filter(Person->Person.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(list);


        List<String> list2 = persons.stream()
                .filter(Person-> Person.getSex() ==Sex.WOMAN)
                .filter(Person-> Person.getAge() > 18 && Person.getAge() < 60)
                .filter(Person->Person.getEducation() == Education.HIGHER)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        List<String> list3 = persons.stream()
                .filter(Person-> Person.getSex() ==Sex.MAN)
                .filter(Person-> Person.getAge() > 18 && Person.getAge() < 65)
                .filter(Person->Person.getEducation() == Education.HIGHER)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        System.out.println("Cписок фамилий потенциально работоспособных людей с высшим образованием: ");
        System.out.println("Женщины:");
        System.out.println(list2);
        System.out.println("Мужчины:");
        System.out.println(list3);
    }
}