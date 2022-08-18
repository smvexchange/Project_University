public class Main {

    public static void main(String[] args) {
        University university = new University();
        Student student1 = new Student("Сидоров Дмитрий", "1/2019", 3, 3.8f);
        Student student2 = new Student("Иванов Иван", "2/2020", 2, 4.2f);
        Student student3 = new Student("Симонова Татьяна", "3/2022", 1, 4.9f);

        System.out.println(university);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}
