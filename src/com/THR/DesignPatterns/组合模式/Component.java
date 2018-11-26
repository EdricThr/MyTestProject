package com.THR.DesignPatterns.组合模式;

public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation();

    /**
     * 叶子不需要使用到的方式未定义为抽象方法，省去在叶子中平庸实现或者再抛异常
     * 而Composite在用到下面的方法时重写方法即可
     * @param component
     * @throws Exception
     */
    public void addComponent(Component component) throws Exception {
        throw new Exception("无权限增加子节点");
    }
    public void removeComponent(Component component) throws Exception {
        throw new Exception("无权限移除子节点");
    }
    public Component getChild(int i) throws Exception {
        throw new Exception("无权限获取子节点");
    }
}
