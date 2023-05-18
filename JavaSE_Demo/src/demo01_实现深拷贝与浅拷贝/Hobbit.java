package demo01_实现深拷贝与浅拷贝;

/**
 * @author ajie
 * @date 2023/5/18
 * @description:
 */
public class Hobbit implements Cloneable{
    private boolean eat;
    private boolean sing;
    private boolean run;

    public Hobbit() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Hobbit(boolean eat, boolean sing, boolean run) {
        this.eat = eat;
        this.sing = sing;
        this.run = run;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public boolean isSing() {
        return sing;
    }

    public void setSing(boolean sing) {
        this.sing = sing;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
