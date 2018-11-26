package com.THR.DesignPatterns.组合模式;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    List<Component> componentList;

    public Composite(String name) {
        super(name);
        this.componentList = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) throws Exception {
        componentList.add(component);
    }

    @Override
    public void removeComponent(Component component) throws Exception {
        componentList.remove(component);
    }

    @Override
    public Component getChild(int i) throws Exception {
        return componentList.get(i);
    }

    @Override
    public void operation() {
        for (Component component : componentList) {
            component.operation();
        }
    }
}
