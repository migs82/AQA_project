package lesson_2;

public class Example {
    public static void main(String[] args) {
        int groupNum = 1;
        int raiting = 5;
        String name = "Vasilij";
        Student ivanov = new Student();
        ivanov.setGroupNum(groupNum); //public - доступен для классов в одном пакете и в подклассах.
        System.out.println("Номер группы " + ivanov.getGroupNum()); //public - виден везде
        ivanov.setName(name); // Метод setName унаследовали из класса Person, public - виден везде
        System.out.println("Имя студента " + ivanov.getName()); // Метод getName унаследовали из класса Person, public - виден везде
        System.out.println("Оценка студента " + ivanov.getRating()); //метод getRating объявлен как defauld в классе Student, доступ будет только для классов в одном пакете.
//ivanov.setRaiting(raiting); - не доступен в данном классе т.к. объявлен в классе Student c модификатором private
    }
}