package ltd.regis.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

public class PersonFactory implements FactoryBean<Person> {
    /*
    * PersonFactory也是bean是个特殊的bean,通过他可以获取普通bean
    * */
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
