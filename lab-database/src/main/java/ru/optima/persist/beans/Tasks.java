package ru.optima.persist.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
//import ru.optima.persist.model.OrderWork;
import ru.optima.persist.model.Work;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class Tasks {
//
//    private List<OrderWork> works;
//
//    @PostConstruct
//    public void init() { works = new ArrayList<>(); }
//
//    public void clear(){
//        works.clear();
//    }
//
//    public void add(Work work) {
//        for (OrderWork i : works){
//            if (i.getWork().getId().equals(work.getId())){
//                i.setQuantity(i.getQuantity() + 1);
//            }
//        }
//        works.add(new OrderWork());
//    }
//
//}
