package factory;


import annotation.Autowired;
import annotation.Component;
import annotation.Configuration;
import annotation.Scan;
import utils.ClassUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FactoryServiceImpl implements FactoryService {
    Map<String,Object> beans = new HashMap<String, Object>();
    public FactoryServiceImpl(Class clazz) throws Exception {
        if(clazz.isAnnotationPresent(Configuration.class) && clazz.isAnnotationPresent(Scan.class)){ // проврка того что appcontext класс
            Scan scan = (Scan) clazz.getAnnotation(Scan.class);
            String basePackage = scan.base();
            List<Class> classes = ClassUtil.getClasses(basePackage); // список всех кандидатов для экземпляров

            beans = classes.stream()
                    .filter(c -> c.isAnnotationPresent(Component.class))
                    .collect(Collectors.toMap(cl -> cl.getSimpleName(), cl -> {
                        try {
                            return cl.newInstance();
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }));
       for(Object bean: beans.values())
       {
           Field[] fields = bean.getClass().getDeclaredFields();
           for(Field field: fields)
           {
               if(field.isAnnotationPresent(Autowired.class))
               {
                   field.setAccessible(true);
                   field.set(bean, beans.get(field.getClass().getSimpleName()));
               }
           }

       }

        }


    }

    @Override
    public Object getBean(Class clazz) {
        return beans.get(clazz.getSimpleName());
    }
}
