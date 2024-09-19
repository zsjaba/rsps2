import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    // Класс School
    class School {
        private String name;
        private String principal;
        private String address;
        private String phone;
        private List<Club> clubs;

        // Конструктор
        public School(String name, String principal, String address, String phone, List<Club> clubs) {
            this.name = name;
            this.principal = principal;
            this.address = address;
            this.phone = phone;
            this.clubs = clubs;
        }

        // Геттеры
        public String getName() {
            return name;
        }

        public String getPrincipal() {
            return principal;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }

        public List<Club> getClubs() {
            return clubs;
        }
    }

    // Класс Club
    class Club {
        private String name;
        private String activityType;
        private int childrenCount;
        private double cost;

        // Конструктор
        public Club(String name, String activityType, int childrenCount, double cost) {
            this.name = name;
            this.activityType = activityType;
            this.childrenCount = childrenCount;
            this.cost = cost;
        }

        // Геттеры
        public String getName() {
            return name;
        }

        public String getActivityType() {
            return activityType;
        }

        public int getChildrenCount() {
            return childrenCount;
        }

        public double getCost() {
            return cost;
        }
    }

    public class SchoolAndClub {
        public static void main(String[] args) {
            // Заполняем список кружков
            List<Club> clubs = new ArrayList<>();
            clubs.add(new Club("Football", "Sports", 15, 300));
            clubs.add(new Club("Chess", "Intellectual", 8, 150));
            clubs.add(new Club("Robotics", "Technology", 12, 500));
            clubs.add(new Club("Dance", "Arts", 20, 250));

            // Заполняем список школ
            List<School> schools = new ArrayList<>();
            schools.add(new School("Greenwood High", "Alice Brown", "123 Elm St", "555-1234", clubs));
            schools.add(new School("Riverside School", "John Doe", "456 Oak St", "555-5678", new ArrayList<>()));

            // Пример отложенного выполнения
            Predicate<School> hasClubs = school -> school.getClubs().size() > 0;
            Stream<School> schoolStream = schools.stream().filter(hasClubs);

            // Пример терминального лямбда-выражения
            schoolStream.forEach(school -> System.out.println("School: " + school.getName()));

            // Пример использования локальной переменной
            double maxCost = 1000;
            List<Club> affordableClubs = clubs.stream()
                    .filter(club -> club.getCost() <= maxCost)
                    .collect(Collectors.toList());

            // Выводим доступные кружки
            affordableClubs.forEach(club -> System.out.println("Affordable Club: " + club.getName()));

            // Пример блочного лямбда-выражения
            Predicate<Club> isPopular = club -> {
                int minChildren = 10;
                return club.getChildrenCount() > minChildren && club.getCost() < 500;
            };

            List<Club> popularClubs = clubs.stream()
                    .filter(isPopular)
                    .collect(Collectors.toList());

            // Выводим популярные кружки
            popularClubs.forEach(club -> System.out.println("Popular Club: " + club.getName()));
        }
    }
