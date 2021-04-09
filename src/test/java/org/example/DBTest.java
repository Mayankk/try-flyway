package org.example;

import org.example.entity.*;
//import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.StreamSupport;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@AutoConfigureEmbeddedDatabase
public class DBTest {
    @Autowired
    private TestEntityRepository testEntityRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testDB(){
        TestEntity entity = new TestEntity(1);

        testEntityRepository.save(entity);

    }

    @Test void testOneToOneRelationship(){
        Address address = new Address("Delhi");

        addressRepository.save(address);

        Address first = addressRepository.findAll().iterator().next();
        Assertions.assertEquals(address.getCity(), first.getCity());
        Assertions.assertNotNull(first.getId());

        Employee employee = new Employee();
        employee.setName("Mayank");
        employee.setAddress(first);

        employeeRepository.save(employee);

        Employee firstEmployee = employeeRepository.findAll().iterator().next();
        Assertions.assertEquals(employee.getName(), firstEmployee.getName());
        long count = StreamSupport.stream(addressRepository.findAll().spliterator(), false).count();
        Assertions.assertEquals(count, 1);
    }
}
