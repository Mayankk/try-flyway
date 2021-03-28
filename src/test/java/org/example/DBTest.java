package org.example;

import org.example.entity.TestEntity;
import org.example.entity.TestEntityRepository;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureEmbeddedDatabase
public class DBTest {
    @Autowired
    private TestEntityRepository testEntityRepository;

    @Test
    public void testDB(){
        TestEntity entity = new TestEntity(1);

        testEntityRepository.save(entity);

    }
}