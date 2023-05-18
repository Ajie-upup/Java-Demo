package demo01_实现深拷贝与浅拷贝;

/**
 * @author ajie
 * @date 2023/5/18
 * @description:
 */
public class CloneTest {
    public static void main(String[] args) {
        Hobbit hobbit = new Hobbit(true, true, true);
        Person person = new Person(18, "ajie", hobbit);
        // 浅拷贝
        Person personShallow = person.cloneShallow();
        System.out.println(person.getHobbit() == personShallow.getHobbit()); // true

        // 深拷贝
        Person personDeep = person.cloneDeep();
        System.out.println(person.getHobbit() == personDeep.getHobbit()); // false
    }
}
