package com.THR.DesignPatterns.���ģʽ;

public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void operation();

    /**
     * Ҷ�Ӳ���Ҫʹ�õ��ķ�ʽδ����Ϊ���󷽷���ʡȥ��Ҷ����ƽӹʵ�ֻ��������쳣
     * ��Composite���õ�����ķ���ʱ��д��������
     * @param component
     * @throws Exception
     */
    public void addComponent(Component component) throws Exception {
        throw new Exception("��Ȩ�������ӽڵ�");
    }
    public void removeComponent(Component component) throws Exception {
        throw new Exception("��Ȩ���Ƴ��ӽڵ�");
    }
    public Component getChild(int i) throws Exception {
        throw new Exception("��Ȩ�޻�ȡ�ӽڵ�");
    }
}
