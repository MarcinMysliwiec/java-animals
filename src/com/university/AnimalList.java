package com.university;

import com.university.Enums.BillType;
import com.university.Enums.CatBreed;
import com.university.Enums.DogBreed;
import com.university.Enums.Gender;
import com.university.Interfaces.FeedableAnimal;
import com.university.Interfaces.PetableAnimal;
import com.university.Models.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AnimalList {
    public static final Scanner CONSOLE = new Scanner(System.in);
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private List<Animal> animalArrayList;

    public AnimalList() {
        animalArrayList = new ArrayList<Animal>();
        initScheduledTasks();
    }

    public void addAnimalToList(Animal animalParam) {
        animalArrayList.add(animalParam);
    }

    private Boolean isValidId(String idParam) {
        for (Animal animal : animalArrayList) {
            if (idParam.equals(animal.getId())) {
                return false;
            }
        }
        return true;
    }

    private String scanForId() {
        CONSOLE.nextLine();
        while (true) {
            String result = CONSOLE.nextLine();
            if (isValidId(result)) {
                return result;
            } else {
                System.out.print(result + " Id jest w użyciu, wybierz inne: ");
            }
        }
    }

    private String scanForString() {
        String result = CONSOLE.nextLine();
        return result;
    }

    private Double scanForDouble() {
        Double result = null;
        while (result == null) {
            try {
                if (CONSOLE.hasNextDouble()) {
                    result = CONSOLE.nextDouble();
                } else if (CONSOLE.hasNextInt()) {
                    result = Double.valueOf(CONSOLE.nextInt());
                } else {
                    throw new InputMismatchException("Podałeś niepoprawny typ danych. Oczekiwany typ - liczba");
                }
            } catch(InputMismatchException e ) {
                System.out.print("Waga musi być liczbą. Spróbuj ponownie: ");
                CONSOLE.nextLine();
            }
        }
        return result;
    }

    private Boolean scanForBoolean() {
        Boolean result = null;
        while (result == null) {
            String action = CONSOLE.nextLine();
            if (action.equalsIgnoreCase("TAK")) {
                result = true;
            } else if (action.equalsIgnoreCase("NIE")) {
                result = false;
            } else {
                System.out.print("Wprowadzono niepoprawne dane. Wpisz tak/nie: ");
            }
        }
        return result;
    }

    private LocalDate scanForDate() {
        LocalDate result = null;
        CONSOLE.nextLine();
        while (result == null) {
            try {
                String str = CONSOLE.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
                result = LocalDate.parse(str, formatter);
            } catch (Exception e) {
                System.out.print("Prawidłowy format daty to " + DATE_FORMAT + ". Spróbuj ponownie: ");
            }
        }
        return result;
    }

    private Gender scanForGender() {
        Gender result = null;
        while (result == null) {
            String action = CONSOLE.nextLine();
            if (action.equalsIgnoreCase("SAMIEC")) {
                result = Gender.MALE;
            } else if (action.equalsIgnoreCase("SAMICA")) {
                result = Gender.FEMALE;
            } else {
                System.out.print("Wybrano niepoprawną akcję. Spróbuj ponownie: ");
            }
        }
        return result;
    }

    private DogBreed scanForDogBreed() {
        DogBreed result = null;
        Integer index = 1;

        System.out.println();
        for (DogBreed breed : DogBreed.values()) {
            System.out.println("\t" + index + ". " + breed.toString());
            index++;
        }

        while (result == null) {
            Integer action = scanForInteger();
            if (action > 0 && action <= BillType.values().length) {
                result = DogBreed.values()[action - 1];
            } else {
                System.out.print("Wybrano niepoprawną akcję. Spróbuj ponownie: ");
            }
        }
        return result;
    }

    private CatBreed scanForCatBreed() {
        CatBreed result = null;
        Integer index = 1;

        System.out.println();
        for (CatBreed breed : CatBreed.values()) {
            System.out.println("\t" + index + ". " + breed.toString());
            index++;
        }

        while (result == null) {
            Integer action = CONSOLE.nextInt();
            if (action > 0 && action <= BillType.values().length) {
                result = CatBreed.values()[action - 1];
            } else {
                System.out.print("Wybrano niepoprawną akcję. Spróbuj ponownie: ");
            }
        }

        return result;
    }

    private BillType scanForBillType() {
        BillType result = null;
        Integer index = 1;

        System.out.println();
        for (BillType bill : BillType.values()) {
            System.out.println("\t" + index + ". " + bill.toString());
            index++;
        }

        while (result == null) {
            Integer action = CONSOLE.nextInt();
            if (action > 0 && action <= BillType.values().length) {
                result = BillType.values()[action - 1];
            } else {
                System.out.print("Wybrano niepoprawną akcję. Spróbuj ponownie: ");
            }
        }

        return result;
    }

    private Integer scanForInteger() {
        Integer result = null;
        while (result == null) {
            try {
                if (CONSOLE.hasNextDouble()) {
                    result = (int) CONSOLE.nextDouble();
                } else if (CONSOLE.hasNextInt()) {
                    result = CONSOLE.nextInt();
                } else {
                    throw new InputMismatchException("Podałeś niepoprawny typ danych. Oczekiwany typ - liczba");
                }
            } catch(InputMismatchException e ) {
                System.out.print("Waga musi być liczbą. Spróbuj ponownie: ");
                CONSOLE.nextLine();
            }
        }
        return result;
    }

    private Dog generateDog() {
        System.out.print("1. Podaj unikalne Id: ");
        String mammalId = scanForId();

        System.out.print("2. Podaj imie zwierzaka: ");
        String mammalName = scanForString();

        System.out.print("3. Podaj wagę zwierzęcia (kg): ");
        Double mammalWeight = scanForDouble();

        System.out.print("4. Podaj Datę urodzenia psa " + DATE_FORMAT + ": ");
        LocalDate mammalDateOfBirth = scanForDate();

        System.out.print("5. Wybierz Płeć (" + Gender.printAll() + "): ");
        Gender mammalGender = scanForGender();

        System.out.print("6. Wybierz rasę: ");
        DogBreed dogBreed = scanForDogBreed();
        return new Dog(mammalId, mammalName, mammalWeight, mammalDateOfBirth, mammalGender, dogBreed);
    }

    private Cat generateCat() {
        System.out.print("1. Podaj unikalne Id: ");
        String mammalId = scanForId();

        System.out.print("2. Podaj imie zwierzaka: ");
        String mammalName = scanForString();

        System.out.print("3. Podaj wagę zwierzęcia (kg): ");
        Double mammalWeight = scanForDouble();

        System.out.print("4. Podaj Datę urodzenia " + DATE_FORMAT + ": ");
        LocalDate mammalDateOfBirth = scanForDate();

        System.out.print("5. Wybierz Płeć (" + Gender.printAll() + "): ");
        Gender mammalGender = scanForGender();

        System.out.print("6. Wybierz rasę: ");
        CatBreed catBreed = scanForCatBreed();
        return new Cat(mammalId, mammalName, mammalWeight, mammalDateOfBirth, mammalGender, catBreed);
    }

    private Mammal generateMammal() {
        System.out.print("1. Podaj unikalne Id: ");
        String mammalId = scanForId();

        System.out.print("2. Podaj imie zwierzaka: ");
        String mammalName = scanForString();

        System.out.print("3. Podaj wagę zwierzęcia (kg): ");
        Double mammalWeight = scanForDouble();

        System.out.print("4. Podaj Datę urodzenia " + DATE_FORMAT + ": ");
        LocalDate mammalDateOfBirth = scanForDate();

        System.out.print("5. Wybierz Płeć (" + Gender.printAll() + "): ");
        Gender mammalGender = scanForGender();

        System.out.print("6. Ilość odnóży: ");
        Integer mammalLegs = scanForInteger();

        System.out.print("7. Czy to zwierzęcie domowe (TAK/NIE): ");
        scanForString();
        Boolean mammalIsDomestic = scanForBoolean();

        return new Mammal(mammalId, mammalName, mammalWeight, mammalDateOfBirth, mammalGender, mammalLegs, mammalIsDomestic);
    }

    private Bird generateBird() {
        System.out.print("1. Podaj unikalne Id: ");
        String birdId = scanForId();

        System.out.print("2. Podaj imie zwierzaka: ");
        String birdName = scanForString();

        System.out.print("3. Podaj wagę zwierzęcia (kg): ");
        Double birdWeight = scanForDouble();

        System.out.print("4. Podaj Datę urodzenia " + DATE_FORMAT + ": ");
        LocalDate birdDateOfBirth = scanForDate();

        System.out.print("5. Wybierz Płeć (" + Gender.printAll() + "): ");
        Gender birdGender = scanForGender();

        System.out.print("6. Typ dzioba: ");
        BillType birdLegs = scanForBillType();

        System.out.print("7. Czy to zwierzęcie domowe (TAK/NIE): ");
        scanForString();
        Boolean birdIsDomestic = scanForBoolean();

        return new Bird(birdId, birdName, birdWeight, birdDateOfBirth, birdGender, birdLegs, birdIsDomestic);
    }

    private Fish generateFish() {
        System.out.print("1. Podaj unikalne Id: ");
        String fishId = scanForId();

        System.out.print("2. Podaj imie zwierzaka: ");
        String fishName = scanForString();

        System.out.print("3. Podaj wagę zwierzęcia (kg): ");
        Double fishWeight = scanForDouble();

        System.out.print("4. Podaj Datę urodzenia " + DATE_FORMAT + ": ");
        LocalDate fishDateOfBirth = scanForDate();

        System.out.print("5. Wybierz Płeć (" + Gender.printAll() + "): ");
        Gender fishGender = scanForGender();

        System.out.print("6. Maksymalne zanurzenie (m): ");
        Double fishMaxSwimDepthParam = scanForDouble();

        System.out.print("7. Czy to zwierzęcie domowe (TAK/NIE): ");
        scanForString();
        Boolean fishIsDomestic = scanForBoolean();

        return new Fish(fishId, fishName, fishWeight, fishDateOfBirth, fishGender, fishMaxSwimDepthParam, fishIsDomestic);
    }

    private Reptile generateReptile() {
        System.out.print("1. Podaj unikalne Id: ");
        String reptileId = scanForId();

        System.out.print("2. Podaj imie zwierzaka: ");
        String reptileName = scanForString();

        System.out.print("3. Podaj wagę zwierzęcia (kg): ");
        Double reptileWeight = scanForDouble();

        System.out.print("4. Podaj Datę urodzenia " + DATE_FORMAT + ": ");
        LocalDate reptileDateOfBirth = scanForDate();

        System.out.print("5. Wybierz Płeć (" + Gender.printAll() + "): ");
        Gender reptileGender = scanForGender();

        System.out.print("6. Czy ma nogi (TAK/NIE): ");
        Boolean reptileHasLegs = scanForBoolean();

        System.out.print("7. Czy to zwierzęcie domowe (TAK/NIE): ");
        Boolean reptileIsDomestic = scanForBoolean();

        return new Reptile(reptileId, reptileName, reptileWeight, reptileDateOfBirth, reptileGender, reptileHasLegs, reptileIsDomestic);
    }

    public void addAnimal() {
        System.out.println("Jakiego typu obiekt chciałbyś utworzyć?");
        System.out.println("1. Pies");
        System.out.println("2. Kot");
        System.out.println("3. Ssak");
        System.out.println("4. Ptak");
        System.out.println("5. Ryba");
        System.out.println("6. Gad");
        System.out.println("0. Wróć");

        Animal animal = null;
        try {
            while (animal == null) {
                if (CONSOLE.hasNextInt()) {
                    Integer action = CONSOLE.nextInt();
                    if (action == 1) {
                        animal = generateDog();
                    } else if (action == 2) {
                        animal = generateCat();
                    } else if (action == 3) {
                        animal = generateMammal();
                    } else if (action == 4) {
                        animal = generateBird();
                    } else if (action == 5) {
                        animal = generateFish();
                    } else if (action == 6) {
                        animal = generateReptile();
                    } else if (action == 0) {
                        System.out.println("Powrót do menu");
                        return;
                    } else {
                        System.out.println("Podałeś liczbę w złym formacie. Spróbuj jeszcze raz");
                    }
                } else {
                    System.out.println("Podałeś niepoprawny typ danych. Oczekiwany typ - liczba całkowita");
                    CONSOLE.nextLine();
                }
            }
            addAnimalToList(animal);
            System.out.println("Pomyślnie dodano zwierzę.");
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd programu.");
        }
    }

    public void removeAnimal() {
        if(animalArrayList.size() == 0) {
            System.out.println("Nie można wykonać akcji. Baza zwierząt jest pusta.");
            return;
        }
        System.out.print("> Podaj id: ");
        String animalId = scanForString();
        removeAnimal(animalId);
    }

    private void removeAnimal(String IdParam) {
        animalArrayList.removeIf(animal -> animal.getId().equals(IdParam));
    }

    public void printAllAnimals() {
        if(animalArrayList.size() == 0) {
            System.out.println("Nie można wykonać akcji. Baza zwierząt jest pusta.");
            return;
        }
        for (Animal animal : animalArrayList) {
            System.out.println(animal);
        }
        System.out.print("Wciśnij enter by kontynuować.");
        scanForString();
    }

    public void printAllAnimalsWithName() {
        if(animalArrayList.size() == 0) {
            System.out.println("Nie można wykonać akcji. Baza zwierząt jest pusta.");
            return;
        }
        System.out.print("> Podaj nazwę: ");
        String animalName = scanForString();
        printAllAnimalsWithName(animalName);
    }

    public void printAllAnimalsWithName(String nameParam) {
        Boolean found = false;
        for (Animal animal : animalArrayList) {
            if(animal.getName().toLowerCase().contains(nameParam.toLowerCase())) {
                found = true;
                System.out.println(animal);
            }
        }
        if(!found) {
            System.out.print("Nie udało się znaleźć zwierzęcia o podanej nazwie.");
        }
        System.out.print("Wciśnij enter by kontynuować.");
        scanForString();
    }

    public void printAnimalByType() {
        System.out.println("Jakiego typu obiekty chciałbyś zobaczyć?");
        System.out.println("1. Pies");
        System.out.println("2. Kot");
        System.out.println("3. Ssak");
        System.out.println("4. Ptak");
        System.out.println("5. Ryba");
        System.out.println("6. Gad");
        System.out.println("0. Wróć");

        String animalType = null;
        try {
            while (animalType == null) {
                Integer action = CONSOLE.nextInt();
                if (action == 1) {
                    animalType = Dog.class.getSimpleName();
                } else if (action == 2) {
                    animalType = Cat.class.getSimpleName();
                } else if (action == 3) {
                    animalType = Mammal.class.getSimpleName();
                } else if (action == 4) {
                    animalType = Bird.class.getSimpleName();
                } else if (action == 5) {
                    animalType = Fish.class.getSimpleName();
                } else if (action == 6) {
                    animalType = Reptile.class.getSimpleName();
                } else if (action == 0) {
                    return;
                } else {
                    System.out.println("Podałeś liczbę w złym formacie. Spróbuj jeszcze raz");
                }
            }
            for (Animal animal : animalArrayList) {
                if(animal.getClass().getSimpleName() == animalType) {
                    System.out.println(animal);
                }
            }

        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd programu.");
        }
    }

    public void petAnimals() {
        try {
            for (Animal animal : animalArrayList) {
                if (animal instanceof PetableAnimal) {
                    ((PetableAnimal) animal).petAnimal();
                }
            }
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd programu.");
        }
    }

    private void initScheduledTasks() {
        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            public void run() {
                for (Animal animal : animalArrayList) {
                    animal.decreaseFoodParam();
                    if (animal instanceof DomesticAnimal) {
                        ((DomesticAnimal) animal).decreaseHappiness();
                    }
                }
            }
        }, 0, 60*1000);
    }

    public void feedAnimals() {
        try {
            for (Animal animal : animalArrayList) {
                if (animal instanceof FeedableAnimal) {
                    ((FeedableAnimal) animal).feedAnimal();
                }
            }
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd programu.");
        }
    }
}
