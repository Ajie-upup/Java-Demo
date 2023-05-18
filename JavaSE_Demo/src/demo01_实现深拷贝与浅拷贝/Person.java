package demo01_实现深拷贝与浅拷贝;

/**
 * @author ajie
 * @date 2023/5/18
 * @description:
 */
public class Person implements Cloneable {
    private Integer age;
    private String name;
    private Hobbit hobbit;

    /**
     * 浅拷贝
     */
    protected Person cloneShallow() {
        try {
            Person person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * 深拷贝
     */
    protected Person cloneDeep() {
        try {
            Person person = (Person) super.clone();
            // 拷贝对象同时拷贝对象中的对象属性
            person.setHobbit((Hobbit) person.getHobbit().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    public Person() {
    }

    public Person(Integer age, String name, Hobbit hobbit) {
        this.age = age;
        this.name = name;
        this.hobbit = hobbit;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hobbit getHobbit() {
        return hobbit;
    }

    public void setHobbit(Hobbit hobbit) {
        this.hobbit = hobbit;
    }
}
