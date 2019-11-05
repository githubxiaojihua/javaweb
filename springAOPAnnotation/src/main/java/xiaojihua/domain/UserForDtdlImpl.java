package xiaojihua.domain;

public class UserForDtdlImpl implements UserForDtdl {
    @Override
    public void save() {
        System.out.println("普通的保存方法...");

    }

    @Override
    public void delete() {
        System.out.println("普通的删除方法...");

    }

    @Override
    public void update() {
        System.out.println("普通的修改方法...");

    }

    @Override
    public void find() {
        System.out.println("普通的查询方法...");

    }
}
