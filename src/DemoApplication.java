import example.AppContext;
import example.service.*;
import factory.FactoryService;
import factory.FactoryServiceImpl;

public class DemoApplication {
    public static void main(String[] args) throws Exception {
        FactoryService service = new FactoryServiceImpl(AppContext.class);
        service.getBean(ServiceImpl.class);
        ColorService red = (ColorService) service.getBean(RedServiceImpl.class);
        red.define();





    }
}
